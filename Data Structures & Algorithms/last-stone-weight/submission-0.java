class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length<1) return -1;
        if(stones.length==1) return stones[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones) maxHeap.offer(stone);
        while(maxHeap.size()>1){
            maxHeap.offer(maxHeap.poll()-maxHeap.poll());
        }
        return maxHeap.peek();
    }
}
