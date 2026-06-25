class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int columnStart = 0;
        int columnEnd = matrix.length - 1;

        int[] c = new int[matrix.length + 1];
        for (int i = 0; i < matrix.length; ++i) {
            c[i] = matrix[i][0];
        }
        c[c.length - 1] = matrix[matrix.length - 1][matrix[0].length - 1];

        int start = 0;
        int end = c.length - 1;
        while (start != end) {
            int mid = start + (end - start) / 2;
            if (target < c[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        int row = start - 1;
        if (row == -1) {
            return false;
        }
        start = 0;
        end = matrix[row].length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = matrix[row][mid];
            if (target < val) {
                end = mid - 1;
            } else if (target > val) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
