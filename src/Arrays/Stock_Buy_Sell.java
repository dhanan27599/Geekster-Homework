package Arrays;

public class Stock_Buy_Sell {
    public static void main(String[] args) {
        int[] arr = {100, 180, 260, 310, 40, 535, 695};
        int result = solve(arr);
        System.out.println(result);
    }

    public static int solve(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if (prices[i] > min) {
                profit = Math.max(profit, prices[i] - min);
            } else {
                min = prices[i];
            }
        }

        return profit;
    }
    
        // int maxProfit = 0;
        // int stock = arr[0];

        // for(int i = 1 ; i < arr.length ; i++) {
        //     if(arr[i] < arr[i - 1]) {
        //         maxProfit += Math.abs(arr[i - 1] - stock);
        //         stock = arr[i];
        //     }
        // }
        // if(stock != arr[arr.length - 1]) {
        //     maxProfit += Math.abs(arr[arr.length - 1] - stock);
        // }
        // return maxProfit;
    // }
}
