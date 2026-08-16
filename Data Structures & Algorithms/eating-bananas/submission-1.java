class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int pile:piles) max = Math.max(max,pile);
        int l=1,r=max,res=max;
        while(l<=r){
            int mid = l+(r-l)/2;
            int totalHrs = isValid(piles,mid);
            if(totalHrs<=h){
                res = Math.min(res,mid);
                r= mid-1;
            }else l = mid+1;
        }
        return res;
    }
    private int isValid(int[] piles, int midVal){
        int total = 0;
        for(int pile :piles){
            total+= (int) Math.ceil((double) pile /midVal);
        }
        return total;
    }
}
