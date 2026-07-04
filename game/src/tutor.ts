import type { GameState } from "./twoSum";

// Calls the local LLM gateway (server/index.js), which proxies to Claude.
// Falls back to a local heuristic hint if the backend/API key is unavailable,
// so the PoC is always playable offline.
export async function askTutor(state: GameState): Promise<string> {
  const payload = {
    problem: "two-sum",
    target: state.target,
    values: state.values,
    moves: state.moves.map((m) => ({ a: m.a, b: m.b, correct: m.correct })),
  };

  try {
    const res = await fetch("/api/hint", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(payload),
    });
    if (!res.ok) throw new Error(`gateway ${res.status}`);
    const data = (await res.json()) as { hint?: string };
    if (data.hint) return data.hint;
    throw new Error("no hint field");
  } catch {
    return localHint(state);
  }
}

// Progressive hint that never gives the final answer outright.
function localHint(state: GameState): string {
  const wrong = state.moves.filter((m) => !m.correct).length;
  if (state.moves.length === 0) {
    return `（本地提示）先想想：對每顆球 x，你要找的搭檔是 ${state.target} - x。與其兩兩暴力嘗試 O(n²)，能不能用一個「記憶集合」把看過的數字記下來？`;
  }
  if (wrong >= 2) {
    const need = state.values.map((v) => `${v}→需要${state.target - v}`).slice(0, 3).join("、");
    return `（本地提示）別急著亂配。逐顆檢查「還缺多少」：${need}…。哪個「還缺的數」剛好也在場上？`;
  }
  return `（本地提示）你已經配對成功過。持續用同一招：掃一顆球就問「${state.target} 減它等於多少、那個數在不在已看過的集合裡」。`;
}
