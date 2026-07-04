import "./style.css";
import { TwoSumStage } from "./physics";
import { askTutor } from "./tutor";
import { newGame, isCleared, type GameState } from "./twoSum";

const $ = (id: string) => document.getElementById(id)!;

let state: GameState;
let stage: TwoSumStage | null = null;
let pairs = 0;
let moves = 0;

function tutorSay(text: string, you = false) {
  const p = document.createElement("p");
  p.className = "tutor-msg" + (you ? " you" : "");
  p.textContent = text;
  const log = $("tutor-log");
  log.appendChild(p);
  log.scrollTop = log.scrollHeight;
}

function refreshHud() {
  $("target").textContent = String(state.target);
  $("pairs").textContent = String(pairs);
  $("moves").textContent = String(moves);
}

function start() {
  if (stage) stage.destroy();
  $("stage").innerHTML = "";
  state = newGame(8, 20);
  pairs = 0;
  moves = 0;
  refreshHud();
  stage = new TwoSumStage($("stage"), state, {
    onMove: () => {
      moves++;
      refreshHud();
    },
    onPair: (correct) => {
      if (correct) {
        pairs++;
        refreshHud();
        if (isCleared(state)) {
          tutorSay(`🎉 神殿修復！你用 ${moves} 步清空了所有合法配對。這正是 Two Sum：對每個 x 找 target - x。`);
        }
      }
    },
  });
}

$("hint-btn").addEventListener("click", async () => {
  const btn = $("hint-btn") as HTMLButtonElement;
  btn.disabled = true;
  btn.textContent = "導師思考中…";
  tutorSay("我卡住了，給我一點方向。", true);
  try {
    const hint = await askTutor(state);
    tutorSay(hint);
  } finally {
    btn.disabled = false;
    btn.textContent = "請導師給提示";
  }
});

$("reset-btn").addEventListener("click", start);

start();
