class Solution {
    private class Pair{
        int curr; int time;
        public Pair(int curr, int time){
            this.curr = curr;
            this.time = time;
        }
    }
    public int leastInterval(char[] tasks, int n) {
                int time = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair> q = new ArrayDeque<>();
        Map<Character,Integer> map = new HashMap<>();
        for(char c: tasks) map.put(c, map.getOrDefault(c,0)+1);
        for(int i:map.values()) maxHeap.add(i);
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            if(maxHeap.size()>0){
                int curr = maxHeap.poll()-1;
                if(curr>0) q.add(new Pair(curr,time+n));
            }
            if(q.size()>0 && q.peek().time==time) maxHeap.add(q.poll().curr);
        }
        return time;
    }
}
