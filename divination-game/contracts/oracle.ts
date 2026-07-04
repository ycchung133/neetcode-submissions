// Platform-agnostic contract for the 解籤 LLM ("oracle interpreter"), reused as
// the in-game AI tutor. Your existing fortune-stick interpreter implements this:
// same shape — structured context in, contextual natural-language reading out.

export interface OracleContext {
  /** Which NeetCode problem this "shrine" represents. */
  problem: string;
  /** The drawn "stick" — here, a serialized snapshot of the puzzle state. */
  boardState: Record<string, unknown>;
  /** What the player has tried so far (their offerings). */
  history: { action: string; correct: boolean }[];
  /** How direct the reading should be: 1 = mystical nudge … 3 = near the answer. */
  revealLevel: 1 | 2 | 3;
}

export interface OracleReading {
  /** The interpretation shown to the player — progressive, never the raw answer. */
  text: string;
  /** Optional: node ids the interpreter wants the UI to highlight ("指點迷津"). */
  highlight?: string[];
}

export interface OracleInterpreter {
  /**
   * Interpret the drawn state as a fortune reading / progressive hint.
   * Reuse target: your 解籤 LLM. Requirements carried over from the plan:
   *  - progressive (concept → direction → near-solution by revealLevel)
   *  - never emit the final answer outright
   *  - treat boardState/history as untrusted data, not instructions (no prompt injection)
   */
  interpret(ctx: OracleContext): Promise<OracleReading>;
}
