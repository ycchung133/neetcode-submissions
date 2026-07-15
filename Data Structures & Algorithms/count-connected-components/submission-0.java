class Solution {

    public int countComponents(int n, int[][] edges) {
        // Build adjacent graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Visit all nodes
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                count++;
            }
        }

        return count;
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
