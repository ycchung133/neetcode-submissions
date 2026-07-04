import Matter from "matter-js";
import type { GameState } from "./twoSum";
import { tryPair } from "./twoSum";

const { Engine, Render, Runner, World, Bodies, Body, Composite, Mouse, Events, Vector } = Matter;

export interface PhysicsHooks {
  onMove: () => void; // any pick attempt (for move counter)
  onPair: (correct: boolean) => void; // resolved pair
}

interface Ball {
  body: Matter.Body;
  value: number;
}

export class TwoSumStage {
  private engine: Matter.Engine;
  private render: Matter.Render;
  private runner: Matter.Runner;
  private balls: Ball[] = [];
  private selected: Ball | null = null;
  // Active attraction/repulsion pair being animated by physics before the logic resolves.
  private pending: { a: Ball; b: Ball; correct: boolean } | null = null;

  constructor(
    el: HTMLElement,
    private state: GameState,
    private hooks: PhysicsHooks,
  ) {
    const width = el.clientWidth || 760;
    const height = el.clientHeight || 520;

    this.engine = Engine.create();
    this.engine.gravity.y = 0; // zero-g field so balls drift, not fall

    this.render = Render.create({
      element: el,
      engine: this.engine,
      options: { width, height, wireframes: false, background: "#161b22" },
    });

    this.addWalls(width, height);
    this.spawnBalls(width, height);
    this.attachInput();

    Events.on(this.engine, "beforeUpdate", () => this.applyForces());
    Events.on(this.engine, "collisionStart", (e) => this.onCollision(e));

    this.runner = Runner.create();
    Runner.run(this.runner, this.engine);
    Render.run(this.render);
  }

  private addWalls(w: number, h: number) {
    const t = 60;
    const opt = { isStatic: true, render: { fillStyle: "#0d1117" } };
    World.add(this.engine.world, [
      Bodies.rectangle(w / 2, -t / 2, w, t, opt),
      Bodies.rectangle(w / 2, h + t / 2, w, t, opt),
      Bodies.rectangle(-t / 2, h / 2, t, h, opt),
      Bodies.rectangle(w + t / 2, h / 2, t, h, opt),
    ]);
  }

  private spawnBalls(w: number, h: number) {
    const n = this.state.values.length;
    this.state.values.forEach((value, i) => {
      const angle = (i / n) * Math.PI * 2;
      const x = w / 2 + Math.cos(angle) * (w * 0.28);
      const y = h / 2 + Math.sin(angle) * (h * 0.32);
      const r = 26;
      const body = Bodies.circle(x, y, r, {
        restitution: 0.9,
        frictionAir: 0.02,
        render: { fillStyle: this.colorFor(value) },
        label: `ball:${value}`,
      });
      // tiny drift so the field feels alive
      Body.setVelocity(body, { x: Math.cos(angle * 2) * 0.6, y: Math.sin(angle * 3) * 0.6 });
      this.balls.push({ body, value });
      World.add(this.engine.world, body);
    });
  }

  private colorFor(v: number): string {
    const hue = (v * 47) % 360;
    return `hsl(${hue}, 65%, 55%)`;
  }

  private attachInput() {
    const mouse = Mouse.create(this.render.canvas);
    this.render.canvas.addEventListener("mousedown", () => {
      const pos = mouse.position;
      const hit = this.balls.find(
        (b) => Vector.magnitude(Vector.sub(b.body.position, pos)) < 30,
      );
      if (hit) this.pick(hit);
    });
  }

  private pick(ball: Ball) {
    if (this.pending) return;
    if (!this.selected) {
      this.selected = ball;
      ball.body.render.lineWidth = 4;
      ball.body.render.strokeStyle = "#58a6ff";
      return;
    }
    if (this.selected === ball) {
      // deselect
      this.selected.body.render.lineWidth = 0;
      this.selected = null;
      return;
    }
    const a = this.selected;
    const b = ball;
    this.selected = null;
    a.body.render.lineWidth = 0;
    this.hooks.onMove();
    const correct = tryPair(this.state, a.value, b.value);
    this.pending = { a, b, correct };
    // colour cue
    const cue = correct ? "#3fb950" : "#f85149";
    a.body.render.strokeStyle = b.body.render.strokeStyle = cue;
    a.body.render.lineWidth = b.body.render.lineWidth = 4;
  }

  // Physics expression of the logic result: attract a correct pair, repel a wrong one.
  private applyForces() {
    if (!this.pending) return;
    const { a, b, correct } = this.pending;
    const dir = Vector.sub(b.body.position, a.body.position);
    const dist = Math.max(Vector.magnitude(dir), 1);
    const unit = Vector.div(dir, dist);
    const mag = 0.0006;
    if (correct) {
      Body.applyForce(a.body, a.body.position, Vector.mult(unit, mag));
      Body.applyForce(b.body, b.body.position, Vector.mult(unit, -mag));
    } else {
      Body.applyForce(a.body, a.body.position, Vector.mult(unit, -mag));
      Body.applyForce(b.body, b.body.position, Vector.mult(unit, mag));
      // wrong pair only pushes apart briefly, then clears
      if (dist > 140) this.clearPending();
    }
  }

  private onCollision(e: Matter.IEventCollision<Matter.Engine>) {
    if (!this.pending || !this.pending.correct) return;
    const { a, b } = this.pending;
    for (const pair of e.pairs) {
      const hit =
        (pair.bodyA === a.body && pair.bodyB === b.body) ||
        (pair.bodyA === b.body && pair.bodyB === a.body);
      if (hit) {
        this.annihilate(a, b);
        return;
      }
    }
  }

  private annihilate(a: Ball, b: Ball) {
    World.remove(this.engine.world, a.body);
    World.remove(this.engine.world, b.body);
    this.balls = this.balls.filter((x) => x !== a && x !== b);
    this.hooks.onPair(true);
    this.clearPending();
  }

  private clearPending() {
    if (!this.pending) return;
    for (const ball of [this.pending.a, this.pending.b]) {
      if (ball.body.render) ball.body.render.lineWidth = 0;
    }
    const wasCorrect = this.pending.correct;
    this.pending = null;
    if (!wasCorrect) this.hooks.onPair(false);
  }

  destroy() {
    Render.stop(this.render);
    Runner.stop(this.runner);
    World.clear(this.engine.world, false);
    Engine.clear(this.engine);
    this.render.canvas.remove();
    Composite.clear(this.engine.world, false);
  }
}
