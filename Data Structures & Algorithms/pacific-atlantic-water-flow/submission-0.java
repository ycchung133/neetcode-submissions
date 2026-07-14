class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for (int r = 0; r < heights.length; ++r) {
            dfs(heights, r, 0, pacific);
        }
        for (int c = 0; c < heights[0].length; ++c) {
            dfs(heights, 0, c, pacific);
        }
        for (int r = 0; r < heights.length; ++r) {
            dfs(heights, r, heights[0].length - 1, atlantic);
        }
        for (int c = 0; c < heights[0].length; ++c) {
            dfs(heights, heights.length - 1, c, atlantic);
        }

        List<List<Integer>> results = new ArrayList<>();
        for (int r = 0; r < heights.length; ++r) {
            for (int c = 0; c < heights[0].length; ++c) {
                if (pacific[r][c] && atlantic[r][c]) {
                    List<Integer> result = new ArrayList<>();
                    result.add(r);
                    result.add(c);
                    results.add(result);
                }
            }
        }
        return results;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited) {
        visited[r][c] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr < 0 || nr >= heights.length) {
                continue;
            }
            if (nc < 0 || nc >= heights[0].length) {
                continue;
            }
            if (visited[nr][nc]) {
                continue;
            }
            if (heights[nr][nc] < heights[r][c]) {
                continue;
            }
            dfs(heights, nr, nc, visited);
        }
    }
}
