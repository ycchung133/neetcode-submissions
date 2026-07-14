class Solution {

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] safe = new boolean[m][n];
        for (int r = 0; r < m; ++r) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0, safe);
            }
            if (board[r][n - 1] == 'O') {
                dfs(board, r, n - 1, safe);
            }
        }
        for (int c = 0; c < n; ++c) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c, safe);
            }
            if (board[m - 1][c] == 'O') {
                dfs(board, m - 1, c, safe);
            }
        }

        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (!safe[r][c]) {
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c, boolean[][] safe) {
        safe[r][c] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr < 0 || nr >= board.length) {
                continue;
            }
            if (nc < 0 || nc >= board[0].length) {
                continue;
            }
            if (safe[nr][nc]) {
                continue;
            }
            if (board[nr][nc] != 'O') {
                continue;
            }
            dfs(board, nr, nc, safe);
        }
    }
}
