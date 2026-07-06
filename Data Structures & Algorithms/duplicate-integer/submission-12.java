class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }

    // public boolean hasDuplicate(int[] nums) {
    //     HashSet<Integer> h = new HashSet<>();
    //     for (int i : nums) {
    //         if (h.contains(i)) {
    //             return true;
    //         }
    //         h.add(i);
    //     }
    //     return false;
    // }
}