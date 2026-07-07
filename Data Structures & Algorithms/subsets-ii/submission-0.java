class Solution {
  
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> results = new HashSet<>();
        HashSet<List<Integer>> newTemp = new HashSet<>();
        results.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int num : nums) {
            for (List<Integer> subset : results) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                newTemp.add(newSubset);
            }
            results.addAll(newTemp);
            newTemp.clear();
        }
        return new ArrayList<>(results);
    }
}
