// Discrete logic layer for the Two Sum level.
// This is the source of truth for correctness — the physics layer only *represents* it.
// Keeping them separate is the core M0 principle: continuous physics for feel,
// discrete state machine for judging whether the algorithm step was valid.

export interface Move {
  a: number; // value of first picked ball
  b: number; // value of second picked ball
  correct: boolean;
}

export interface GameState {
  values: number[]; // remaining ball values on the field
  target: number;
  solvedPairs: [number, number][];
  moves: Move[];
}

export function newGame(size = 8, maxVal = 20): GameState {
  // Deterministic-ish layout without Math.random (kept reproducible for testing):
  // caller may pass a fixed array via loadGame instead.
  const values: number[] = [];
  let seed = size * 7 + maxVal; // simple LCG so we avoid Math.random for reproducibility
  const next = () => (seed = (seed * 1103515245 + 12345) & 0x7fffffff);
  for (let i = 0; i < size; i++) values.push((next() % maxVal) + 1);

  // Guarantee at least one valid pair exists by picking a real target.
  const i = next() % values.length;
  let j = next() % values.length;
  if (j === i) j = (j + 1) % values.length;
  const target = values[i] + values[j];

  return { values, target, solvedPairs: [], moves: [] };
}

// Attempt to remove a pair. Returns whether it was a valid Two Sum pair.
export function tryPair(state: GameState, valA: number, valB: number): boolean {
  const correct = valA + valB === state.target;
  state.moves.push({ a: valA, b: valB, correct });
  if (correct) {
    state.solvedPairs.push([valA, valB]);
    // remove one instance of each value
    removeOne(state.values, valA);
    removeOne(state.values, valB);
  }
  return correct;
}

function removeOne(arr: number[], v: number) {
  const idx = arr.indexOf(v);
  if (idx >= 0) arr.splice(idx, 1);
}

// Is there still any valid pair left on the field?
export function hasSolution(state: GameState): boolean {
  const seen = new Set<number>();
  for (const v of state.values) {
    if (seen.has(state.target - v)) return true;
    seen.add(v);
  }
  return false;
}

export function isCleared(state: GameState): boolean {
  return !hasSolution(state);
}
