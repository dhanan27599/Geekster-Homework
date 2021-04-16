package Arrays;
/*
In share trading, a buyer buys shares and sells on a future date. 
Given the stock price of n days, 
the trader is allowed to make at most k transactions, 
where a new transaction can only start after the previous transaction is complete, 
find out the maximum profit that a share trader could have made.

Examples:

Input:  
Price = [10, 22, 5, 75, 65, 80]
    K = 2
Output:  87
Trader earns 87 as sum of 12 and 75
Buy at price 10, sell at 22, buy at 
5 and sell at 80

Input:  
Price = [12, 14, 17, 10, 14, 13, 12, 15]
    K = 3
Output:  12
Trader earns 12 as the sum of 5, 4 and 3
Buy at price 12, sell at 17, buy at 10 
and sell at 14 and buy at 12 and sell
at 15
 
Input:  
Price = [100, 30, 15, 10, 8, 25, 80]
    K = 3
Output:  72
Only one transaction. Buy at price 8 
and sell at 80.

Input:  
Price = [90, 80, 70, 60, 50]
    K = 1
Output:  0
Not possible to earn. 
 */
public class Max_Profit_Sell_K_times {
    public static void main(String[] args) {
        System.out.println(solve(new int[] {10, 22, 5, 75, 65, 80}, 2)); 
    }

    public static int solve(int[] prices, int k) {
        int maxProfit = 0;
        int i = 0;
        while(i < prices.length && k >= 0) {
            int profit = 0;
            int min = prices[i];
            int j = i + 1;
            if(k > 1) {
                while(j < prices.length && prices[j] > prices[j - 1]) {
                    profit += prices[j] - prices[j - 1];
                    j++;
                }
            } else {
                while(j < prices.length) {
                    if(prices[j] > min) {
                        profit = Math.max(profit, prices[j] - min);
                        j++;
                    } else {
                        min = prices[j];
                        j++;
                    }
                }
            }
            i = j;
            maxProfit += profit;
            k--;
        }
        return maxProfit;
    }
}
