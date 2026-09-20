class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //        sqrt((x1 - x2)^2 + (y1 - y2)^2)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (b,a)->  Double.compare(
                        Math.sqrt(Math.pow(a[0]-0,2)+Math.pow(a[1]-0,2)),
                        Math.sqrt(Math.pow(b[0]-0,2)+Math.pow(b[1]-0,2))));
        for(int[] point:points){
            maxHeap.offer(point);
            if(maxHeap.size()>k) maxHeap.poll();
        }

        int[][] result = new int[k][2];
        while (k > 0) {
            result[--k] = maxHeap.poll();
        }

        return result;

    }
}
