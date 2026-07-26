class Solution {
    class Pair{
        public int idx,height;
        public Pair(int idx,int height){
            this.idx = idx;
            this.height = height;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Pair> stack = new ArrayDeque<>();
        int maxHeight = 0;
        for(int i=0;i<heights.length;i++){
            Pair currentPair = new Pair(i,heights[i]);
            while(!stack.isEmpty() && stack.peek().height>currentPair.height){
                Pair popped = stack.pop();
                int currentHeight = (i-popped.idx)*popped.height;
                maxHeight = Math.max(maxHeight,currentHeight);
                currentPair.idx = popped.idx;
            }
            stack.push(currentPair);
        }
        for(Pair p:stack){
            maxHeight = Math.max(maxHeight,p.height*(heights.length-p.idx));
        }
        return maxHeight;
    }
}
