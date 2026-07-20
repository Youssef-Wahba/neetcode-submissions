class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k) return nums;
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(int n: nums)
            map.put(n,map.getOrDefault(n,0)+1);
        for(int key:map.keySet()){
            heap.add(key);
            if(heap.size()>k) heap.poll();
        }
        int[] ans= new int[k];
        for(int i=0;i<k;i++)
            ans[i] = heap.poll();
        return ans;
    }
}
