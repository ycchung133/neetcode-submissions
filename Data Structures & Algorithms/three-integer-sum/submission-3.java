class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0;i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -1 * nums[i];
            int p1 = i + 1;
            int p2 = nums.length - 1;
            while (p1 < p2) {
                int sum = nums[p1] + nums[p2];
                if (sum < target) {
                    p1 += 1;
                } else if (sum > target) {
                    p2 -= 1;
                } else {
                    List<Integer> pr = new ArrayList<>();
                    pr.add(nums[i]);
                    pr.add(nums[p1]);
                    pr.add(nums[p2]);
                    result.add(pr);
                    while (p1 < p2 && nums[p1] == nums[p1 + 1]) p1++;
                    while (p2 < p2 && nums[p2] == nums[p2 - 1]) p2--;
                    p1++;
                    p2--;
                }
            }
        }
        return result;
    }

    public List<int[]> twoSum(int[] numbers, int target, int start) {
        int p1 = start + 1;
        int p2 = numbers.length - 1;
        List<int[]> result = new ArrayList<>();
        while (p1 < p2) {
            int sum = numbers[p1] + numbers[p2];
            if (sum < target) {
                p1 += 1;
            } else if (sum > target) {
                p2 -= 1;
            } else {
                result.add(new int[]{numbers[p1], numbers[p2]});
            }
        }
        return result;
    }
}
