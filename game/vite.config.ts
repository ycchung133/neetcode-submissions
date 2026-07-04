import { defineConfig } from "vite";

// Frontend dev server proxies /api/* to the local LLM gateway (server/index.js).
export default defineConfig({
  server: {
    port: 5173,
    proxy: {
      "/api": "http://localhost:8787",
    },
  },
});
