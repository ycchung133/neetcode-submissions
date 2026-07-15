class Solution {
 
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Build the adjacent graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }

        int[] state = new int[numCourses];
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (hasCycle(graph, i, state, order)) {
                return new int[0];
            }
        }
        Collections.reverse(order);
        int[] result = new int[order.size()];
        for (int i = 0; i < order.size(); ++i) {
            result[i] = order.get(i);
        }
        return result;
    }

    private boolean hasCycle(List<List<Integer>> graph, int course, int[] state, List<Integer> order) {
        if (state[course] == 1) {
            return true;
        }
        if (state[course] == 2) {
            return false;
        }
        state[course] = 1;
        for (int next : graph.get(course)) {
            if (hasCycle(graph, next, state, order)) {
                return true;
            }
        }
        order.add(course);
        state[course] = 2;
        return false;
    }
}
