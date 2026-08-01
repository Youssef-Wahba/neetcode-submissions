class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
                if(nums.length<k) return new int[]{};
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        int[] res = new int[nums.length-k+1];
        for(int i =k-1;i<nums.length;i++){
            heap.clear();
            for(int j=i-k+1;j<=i;j++){
                heap.add(nums[j]);
            }
            res[i+1-k] = heap.peek();
        }
        return res;
    }
}
