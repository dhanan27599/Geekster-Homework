package Arrays;
/*
Given an array arr[] of n integers, 
find the maximum that maximizes the sum of the value of i*arr[i] 
where i varies from 0 to n-1.

Examples:  

Input: arr[] = {8, 3, 1, 2}
Output: 29
Explanation: Lets look at all the rotations,
{8, 3, 1, 2} = 8*0 + 3*1 + 1*2 + 2*3 = 11
{3, 1, 2, 8} = 3*0 + 1*1 + 2*2 + 8*3 = 29
{1, 2, 8, 3} = 1*0 + 2*1 + 8*2 + 3*3 = 27
{2, 8, 3, 1} = 2*0 + 8*1 + 3*2 + 1*3 = 17

Input: arr[] = {3, 2, 1}
Output: 7
Explanation: Lets look at all the rotations,
{3, 2, 1} = 3*0 + 2*1 + 1*2 = 4
{2, 1, 3} = 2*0 + 1*1 + 3*2 = 7
{1, 3, 2} = 1*0 + 3*1 + 2*2 = 7
*/
public class Max_Sum_Index_Multiplied_Rotated_Array {
    public static void main(String[] args) {
        int[] arr = {8, 3, 1, 2};
        int result = solve(arr);
        System.out.println(result);
    }

    private static int solve(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int i;
        int pivot = findPivot(arr, n);
        int diff = n - 1 - pivot;
        for(i = 0; i < n; i++){
            int bestIdx = (i + diff) % n;
            sum= sum + (bestIdx) * arr[i];
        }
        return sum;
        // int valSum = 0;
        // for(int i : arr) {
        //     valSum += i;
        // }

        // int currentSum = 0;
        // for(int i = 0 ; i < arr.length ; i++) {
        //     currentSum += i * arr[i];
        // }
        // int res = currentSum;

        // for(int i = 1 ; i < arr.length ; i++) {
        //     int nextSum = currentSum - (valSum - arr[i - 1]) + arr[i - 1] * (n - 1);
        //     currentSum = nextSum;
        //     res = Math.max(nextSum, res); 
        // }
        // return res;
    }

    private static int findPivot(int[] arr, int n) {
        for(int i = 0 ; i < arr.length - 1 ; i++) {
            if(arr[i] > arr[(i + 1) % n]) {
                return i;
            }
        }
        return 0;
    }
}
