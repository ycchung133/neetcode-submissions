// Platform-agnostic physics-engine contract.
// The reused 擲茭 (jiaobei toss) and 吊酒瓶 (bottle-hooking) engines each implement
// this via an adapter — Unity, Android/Box2D, or web/matter.js. Gameplay logic
// depends ONLY on these interfaces, never on a concrete engine.

// ---- 擲茭：拋擲剛體 → 離散落地狀態 -------------------------------------------

/** The three canonical jiaobei outcomes. */
export type JiaobeiResult =
  | "sheng" // 聖筊：一平一凸 → 肯定
  | "xiao" // 笑筊：兩平    → 再想想
  | "yin"; // 陰筊：兩凸    → 否定

export interface TossEngine {
  /**
   * Toss the divination blocks. The engine simulates rigid-body physics and
   * resolves to ONE discrete outcome — the classic "physics expresses, discrete
   * state machine judges" split. `impulse` lets gameplay vary the throw.
   */
  toss(impulse?: { x: number; y: number; spin: number }): Promise<JiaobeiResult>;
}

// ---- 吊酒瓶：繩索 / 鉤子 / 約束 / 平衡 ---------------------------------------

export interface Vec2 {
  x: number;
  y: number;
}

/** A physical node in a rope/constraint scene (a ball, a bottle, a tree node). */
export interface PhysNode {
  id: string;
  position: Vec2;
  value?: number; // algorithm payload (e.g. list value, key)
}

/** A rope/joint constraint between two nodes — the "pointer" of a linked list/edge of a tree. */
export interface Link {
  from: string;
  to: string;
}

export interface RopeEngine {
  spawnNode(value: number, at: Vec2): PhysNode;
  /** Create a rope/constraint between two nodes (list next / tree edge). */
  link(fromId: string, toId: string): Link;
  /** Cut a rope — the core "unlink" gesture (reverse list, rotate tree). */
  cut(link: Link): void;
  /** Hook & lift a node into place — the 吊酒瓶 precision mechanic. */
  hook(nodeId: string, to: Vec2): Promise<boolean>;
  /** Current constraint graph, for the discrete state machine to judge against. */
  snapshot(): { nodes: PhysNode[]; links: Link[] };
  onSettle(cb: () => void): void; // fires when the scene stops moving
}
