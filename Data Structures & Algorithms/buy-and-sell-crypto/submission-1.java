class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int l=0,profit=0;
        for(int r=1;r<prices.length;r++){
            while (prices[l]>prices[r]) l++;
            profit = Math.max(profit, prices[r]-prices[l]);
        }
        return profit;
    }
}
