class Solution {


    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        // Build adjacent graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        dfs(graph, 0, visited);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> graph, int node, boolean[] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int next : graph.get(node)) {
            dfs(graph, next, visited);
        }
    }
}
