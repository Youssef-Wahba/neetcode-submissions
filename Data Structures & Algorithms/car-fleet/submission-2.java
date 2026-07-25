class Solution {
    class Pair{
        public int pos,speed;
        public Pair(int pos,int speed){
            this.pos = pos;
            this.speed = speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length<=1) return position.length;
        Pair[] pairs = new Pair[position.length];
        for(int i=0;i<position.length;i++){
            pairs[i] = new Pair(position[i],speed[i]);
            pairs[i].pos = position[i];
            pairs[i].speed = speed[i];
        }
        Arrays.sort(pairs,(a,b)->b.pos - a.pos);
        Stack<Pair> stack = new Stack<>();
        for(Pair p: pairs){
            if(stack.isEmpty()){
                stack.push(p);
            }
            else if(((target-stack.peek().pos)/(double)stack.peek().speed) < (((target-p.pos)/(double)p.speed))){
                stack.push(p);
            }
        }
        return stack.size();
    }
}
