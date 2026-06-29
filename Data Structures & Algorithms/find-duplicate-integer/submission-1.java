class Solution {

    public int findDuplicate(int[] nums) {
        int i1 = 0;
        int i2 = 0;
        
        do {
            i1 = nums[i1];
            i2 = nums[i2];
            i2 = nums[i2];
        } while (i1 != i2);

        i1 = 0;
        while (i1 != i2) {
            i1 = nums[i1];
            i2 = nums[i2];
        }

        return i1;
    }


    // public int findDuplicate(int[] nums) {
    //     HashSet<Integer> set = new HashSet<Integer>();
    //     for (int i : nums) {
    //         if (set.contains(i)) {
    //             return i;
    //         }
    //         set.add(i);
    //     }
    //     return -1;
    // }
}
