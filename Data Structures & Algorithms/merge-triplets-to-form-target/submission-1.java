class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        for (int i = 0;i < triplets[0].length; ++i) {
            boolean found = false;

            for(int j = 0; j < triplets.length; ++j) {
                boolean isSafe = triplets[j][0] <= target[0] && triplets[j][1] <= target[1] && triplets[j][2] <= target[2];
                if (isSafe && triplets[j][i] == target[i]) {
                    found = true;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
