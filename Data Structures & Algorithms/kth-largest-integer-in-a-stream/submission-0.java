class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        minHeap = new PriorityQueue<>();
        for(int n:nums) minHeap.offer(n);
        while(minHeap.size()>k) minHeap.poll();
    }

    public int add(int val) {
        minHeap.add(val);
        while(minHeap.size()>k) minHeap.poll();
        return minHeap.peek();
    }
}
