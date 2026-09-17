class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for (int n : nums) {
            int size = results.size();
            for (int i = 0; i < size; ++i) {
                List<Integer> base = results.remove(0);
                for (int index = 0; index <= base.size(); ++index) {
                    List<Integer> newList = new ArrayList<>(base);
                    newList.add(index, n);
                    results.add(newList);
                }
            }
        }
        return results;
    }
}
