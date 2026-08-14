class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0,r=matrix.length;
        while(l<r){
            int mid = l+(r-l)/2;
            if(matrix[mid][matrix[mid].length-1]>= target && matrix[mid][0]<=target){
                l = mid;
                break;
            }
            if(matrix[mid][0]>target) r = mid;
            else l = mid+1;
        }
        if(l == matrix.length) return false;
        int[] targetRow=matrix[l];
        l = 0;
        r = targetRow.length;
        while(l<r){
            int mid = l+(r-l)/2;
            if(targetRow[mid] == target) return true;
            else if(targetRow[mid]>target) r = mid;
            else l = mid+1;
        }
        return false;
    }
}
