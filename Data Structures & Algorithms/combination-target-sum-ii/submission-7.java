class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> temp = new ArrayList<>();
        List<Integer> sums = new ArrayList<>();
        List<Integer> starts = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        temp.add(new ArrayList<>());
        sums.add(0);
        starts.add(0);
        while (!temp.isEmpty()) {
            int size = temp.size();
            for (int i = 0;i < size; ++i) {
                List<Integer> base = temp.remove(0);
                int sum = sums.remove(0);
                int start = starts.remove(0);
                for (int index = start; index < candidates.length; ++index) {
                    int n = candidates[index];
                    // if (n + sum > target) {
                    //     break;
                    // }
                    if (index > start && candidates[index] == candidates[index - 1]) {
                        continue;
                    }
                    List<Integer> newList = new ArrayList<>(base);
                    newList.add(n);
                    int newSum = sum + n;
                    if (newSum < target) {
                        temp.add(newList);
                        sums.add(newSum);
                        starts.add(index + 1);
                    } else if (newSum == target) {
                        results.add(newList);
                    }
                }
            }
        }
        return results;
    }
}
