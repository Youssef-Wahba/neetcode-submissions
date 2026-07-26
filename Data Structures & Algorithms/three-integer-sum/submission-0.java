class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3) return new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) break;
            int l=i+1,r=nums.length-1;
            while(l<r){
                int sum = nums[l] + nums[r];
                if(sum>-nums[i]) r--;
                else if(sum<-nums[i]) l++;
                else{
                    set.add(new ArrayList<>(List.of(nums[i],nums[l],nums[r])));
                    l++;
                    r--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
