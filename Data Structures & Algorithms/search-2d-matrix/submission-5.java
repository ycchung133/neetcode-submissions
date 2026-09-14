class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int w = matrix[0].length;
        int h = matrix.length;
        int end = w * h - 1;
        while (start <= end) {
            int index = start + (end - start) / 2;
            int mid = matrix[index / w][index % w];
            if (mid < target) {
                start = index + 1;
            } else if (mid > target){
                end = index - 1;
            } else {
                return true;
            }
        }
        return false;
    }



    
}
