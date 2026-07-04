# AlgoPhysics 150 — M0 PoC

「Two Sum 神殿」垂直切片：**matter.js 物理** × **Claude 導師**。
驗證計畫書（`../GAME_PROPOSAL.md`）的核心假設——物理層負責*表現*、離散狀態機負責*正確性判定*，兩者用事件同步。

## 玩法
- 場上有一圈標了數字的球，上方顯示「目標和」。
- 點兩顆球選出一對：
  - 兩數之和 **= 目標** → 物理**吸引**，相撞後湮滅、得分。
  - 不等於 → 物理**彈開**。
- 清空所有合法配對即修復神殿。卡住就按「請導師給提示」。

## 架構
```
src/twoSum.ts   離散狀態機（正確性的唯一真相來源）
src/physics.ts  matter.js 物理表現（吸引/排斥/湮滅）
src/tutor.ts    前端呼叫 /api/hint，失敗時退回本地提示
src/main.ts     HUD + 事件串接
server/index.js LLM gateway：代理 Claude Messages API（無 key 時本地退化）
```

## 執行
```bash
cd game
npm install

# 終端機 A：LLM gateway（可選，沒有也能玩，會用本地提示）
export ANTHROPIC_API_KEY=sk-ant-...   # 不設就走本地退化
npm run server

# 終端機 B：前端
npm run dev          # http://localhost:5173
```
Vite 會把 `/api/*` 代理到 `localhost:8787`。導師預設用 `claude-haiku-4-5-20251001`（便宜快速），可用 `TUTOR_MODEL` 覆寫。

## 這個 PoC 驗證了什麼
1. **物理↔邏輯同步**：`tryPair()` 判定對錯，物理層據此施加吸引或排斥力——表現與判定解耦。
2. **LLM 導師迴圈**：遊戲狀態序列化 → gateway → Claude → 漸進式提示（不直接給答案），且系統 prompt 與玩家資料分離（防提示注入）。
3. **無 key 可玩**：後端/API 不可用時退回本地啟發式提示，Demo 永不開天窗。

## 下一步（M1）
- 抽出可重用的「物理元件模板」（球、繩、堆疊塔），讓其他題型組裝複用。
- 加入 Stack（Valid Parentheses）與 Two Pointers（Container With Most Water）關卡。
- 導師 tool use：讓 Claude 能「高亮」場上某顆球，邊講邊指。
