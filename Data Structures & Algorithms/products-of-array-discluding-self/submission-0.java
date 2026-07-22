class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix = 1, postfix=1;
        int[] res = new int[nums.length];
        for(int i=0; i<res.length; i++){
            res[i]= prefix;
            prefix*= nums[i];

        }
        for(int i = res.length-1; i>=0; i--){
            res[i]*= postfix;
            postfix*= nums[i];
        }
        return res; 
    }
}  
