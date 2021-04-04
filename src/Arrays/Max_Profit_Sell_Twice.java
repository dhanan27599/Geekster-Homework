package Arrays;

/*
In daily share trading, a buyer buys shares in the morning and sells them on the same day. 
If the trader is allowed to make at most 2 transactions in a day, 
whereas the second transaction can only start after the first one is complete 
(Sell->buy->sell->buy). 

Given stock prices throughout the day, 
find out the maximum profit that a share trader could have made.

Examples: 

Input:   price[] = {10, 22, 5, 75, 65, 80}
Output:  87
Trader earns 87 as sum of 12, 75 
Buy at 10, sell at 22, 
Buy at 5 and sell at 80

Input:   price[] = {2, 30, 15, 10, 8, 25, 80}
Output:  100
Trader earns 100 as sum of 28 and 72
Buy at price 2, sell at 30, buy at 8 and sell at 80

Input:   price[] = {100, 30, 15, 10, 8, 25, 80};
Output:  72
Buy at price 8 and sell at 80.

Input:   price[] = {90, 80, 70, 60, 50}
Output:  0
Not possible to earn.
 */

public class Max_Profit_Sell_Twice {
    public static void main(String[] args) {
        int[] prices = {90, 80, 70, 60, 50};
        int profit = solve(prices);
        System.out.println(profit);
    }

    public static int solve(int[] prices) {
        int maxProfit = 0;
        int i = 0;
        int min = prices[0];
        for(i = 1 ;  i < prices.length && maxProfit == 0 ; ++i) {
            if(prices[i] > min) {
                maxProfit = prices[i] - min;
                break;
            } else {
                min = prices[i];
            }
        } 
        if(i >= prices.length - 1) {
            return maxProfit;
        }
        int profit = 0;
        min = prices[i];
        for(int j = i + 1 ; j < prices.length ; j++) {
            if(prices[j] > min) {
                profit = Math.max(profit, prices[j] - min);
            } else {
                min = prices[j];
            }
        }
        maxProfit += profit;
        return maxProfit;
    }
}