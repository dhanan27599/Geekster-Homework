package Arrays;
import java.util.*;
/*
Given two integer arrays arr1[] and arr2[] sorted in ascending order and an integer k. 
Find k pairs with smallest sums such that one element of a pair 
belongs to arr1[] and other element belongs to arr2[]

Examples: 
Input :  
arr1[] = {1, 7, 11}
arr2[] = {2, 4, 6}
k = 3

Output : 
[1, 2],
[1, 4],
[1, 6]

Explanation: The first 3 pairs are returned 
from the sequence [1, 2], [1, 4], [1, 6], 
[7, 2], [7, 4], [11, 2], [7, 6], [11, 4], 
[11, 6]

*/
class KPairs_Smallest_Sum {
    public static void main(String[] args) {
        int[] arr1 = {1, 7, 11};
        int[] arr2 = {2, 4, 6};
        int k = 3;

        int[][] result = solve(arr1, arr2, k);

        for(int i = 0 ; i < result.length ; i++) {
            for(int j = 0 ; j < 2 ; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solve(int[] arr1, int[] arr2, int k) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        for(int i : arr1) {
            pq1.add(i);
        }

        for(int i : arr2) {
            pq2.add(i);
        }
        int[][] result = new int[k][2];
        int l = 0;
        while(l < k) {
            if(pq1.peek() < pq2.peek()) {
                result[l++] = new int[]{pq1.peek(), pq2.poll()};
            } else {
                result[l++] = new int[]{pq1.poll(), pq2.peek()};
            }
        }
        return result;
    }
}