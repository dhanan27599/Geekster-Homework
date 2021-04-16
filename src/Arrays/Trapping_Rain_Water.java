package Arrays;
/*
Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
Examples:  
Input: arr[]   = {2, 0, 2}
Output: 2
Explanation:
We can trap 2 units of water in the middle gap.

Input: arr[]   = {3, 0, 2, 0, 4}
Output: 7
Explanation:
We can trap "3 units" of water between 3 and 2,
"1 unit" on top of bar 2 and "3 units" between 2 
and 4.  See below diagram also.

Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Output: 6

*/
public class Trapping_Rain_Water {
    public static void main(String[] args) {
        // int[] arr = {2, 0, 2};
        // int[] arr = {3, 0, 2, 0, 4};
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = solve(arr);
        System.out.println(result);
    }

    public static int solve(int[] arr) {
        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];
        leftMax[0] = arr[0];
        rightMax[rightMax.length - 1] = arr[arr.length - 1];
        for(int i = 1, j = rightMax.length - 2 ; i < arr.length && j >= 0 ; i++, j--) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
            rightMax[j] = Math.max(rightMax[j + 1], arr[j]);
        }
        int result = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if(Math.abs(min - arr[i]) > 0) {
                result += Math.abs(min - arr[i]);
            }
        }

        return result;
    }
}
