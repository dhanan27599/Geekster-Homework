package Arrays;
import java.util.*;
/**
 * You are given an array A with size N (indexed from 0) and an integer K. 
 * Let's define another array B with size N · K as the array that's formed by concatenating K copies of array A.
 * For example, if A = {1, 2} and K = 3, then B = {1, 2, 1, 2, 1, 2}.
 * You have to find the maximum subarray sum of the array B. 
 * Fomally, you should compute the maximum value of Bi + Bi+1 + Bi+2 + ... + Bj, where 0 ≤ i ≤ j < N · K.
 * 
 * Input:
 * The first line of the input contains a single integer T denoting the number of test cases. 
 * The description of T test cases follows.
 * The first line of each test case contains two space-separated integers N and K.
 * The second line contains N space-separated integers A0, A1, ..., AN-1.
 * 
 * Output:
 * For each test case, print a single line containing the maximum subarray sum of B.
 * 
 * Constraints:
 * 1 ≤ T ≤ 10
 * 1 ≤ N ≤ 105
 * 1 ≤ K ≤ 105
 * -106 ≤ Ai ≤ 106 for each valid i
 * 
 * Subtasks:
 * Subtask #1 (18 points): N · K ≤ 105
 * Subtask #2 (82 points): original constraints
 * 
 * Example:
 * Input:
 * 2
 * 2 3
 * 1 2
 * 3 2
 * 1 -2 1
 * 
 * Output:
 * 9
 * 2
 * 
 */

public class K_Concatenation{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(n, k, arr));
        sc.close();
    }

    public static int solve(int n, int k, int[] arr) {
        int[] concatenatedArr = new int[n * k];

        for(int i = 0 ; i < concatenatedArr.length ; i++) {
            concatenatedArr[i] = arr[i % n];
        }
        int maxSum = concatenatedArr[0];
        int currentSum = concatenatedArr[0];

        for(int i = 1 ; i < concatenatedArr.length ; i++) {
            currentSum += concatenatedArr[i];
            if(currentSum > maxSum) {
                maxSum = currentSum;
            } else {
                currentSum = concatenatedArr[i];
            }
            
        }

        return maxSum;
    }

}