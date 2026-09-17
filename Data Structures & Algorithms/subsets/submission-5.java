class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for (int n : nums) {
            int size = results.size();
            for (int i = 0; i < size; ++i) {
                List<Integer> newList = new ArrayList<>(results.get(i));
                newList.add(n);
                results.add(newList);
            }
        }
        return results;
    }
}
