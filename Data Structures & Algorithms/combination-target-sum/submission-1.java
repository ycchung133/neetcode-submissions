class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> temp = new ArrayList<>();
        List<Integer> sums = new ArrayList<>();
        List<Integer> starts = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        temp.add(new ArrayList<>());
        sums.add(0);
        starts.add(0);
        while (!temp.isEmpty()) {
            int size = temp.size();
            for (int i = 0; i < size; ++i) {
                List<Integer> base = temp.remove(0);
                int baseSum = sums.remove(0);
                int start = starts.remove(0);
                for (int j = start; j < nums.length; ++j) {
                    int n = nums[j];
                    List<Integer> newList = new ArrayList<>(base);
                    newList.add(n);
                    int newSum = baseSum + n;
                    if (newSum < target) {
                        temp.add(newList);
                        sums.add(baseSum + n);
                        starts.add(j);
                    } else if (newSum == target) {
                        results.add(newList);
                    }
                }
            }
        }
        return results;
    }
}
