class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> starts = new ArrayList<>();
        results.add(new ArrayList<>());
        int start = 0;
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            if (!(i > 0 && nums[i] == nums[i - 1])) {
                start = 0;
            }
            int size = results.size();
            for (int j = start; j < size; ++j) {
                List<Integer> newList = new ArrayList<>(results.get(j));
                newList.add(n);
                results.add(newList);
            }
            start = size;
        }
        return results;
    }
}
