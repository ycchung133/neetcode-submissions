class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for (int num : nums) {
            int size = results.size();
            for (int i = 0; i < size; ++i) {
                List<Integer> newSubset = new ArrayList<>(results.get(i));
                newSubset.add(num);
                results.add(newSubset);
            }
        }
        return results;
    }
    
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> results = new ArrayList<>();
    //     results.add(new ArrayList<>());
    //     for (int n : nums) {
    //         int size = results.size();
    //         for (int i = 0; i < size; ++i) {
    //             List<Integer> newSubset = new ArrayList<>(results.get(i));
    //             newSubset.add(n);
    //             results.add(newSubset);
    //         }
    //     }
    //     return results;
    // }

}
