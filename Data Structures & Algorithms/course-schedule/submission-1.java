class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build the adjacent
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }


        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (hasCycle(graph, i, state)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int course, int[] state) {
        if (state[course] == 1) {
            return true;
        }
        if (state[course] == 2) {
            return false;
        }
        state[course] = 1;
        for (int next : graph.get(course)) {
            if (hasCycle(graph, next, state)) {
                return true;
            }
        }
        state[course] = 2;
        return false;
    }
}
