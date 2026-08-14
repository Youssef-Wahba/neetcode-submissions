class Solution {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length;
        while(r-l>1){
            int mid = l+(r-l)/2;
            if(nums[mid]>target) r = mid;
            else l =mid;
        }
        return nums[l] == target? l : -1;
    }
}
