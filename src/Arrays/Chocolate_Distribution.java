package Arrays;
import java.util.*;
/*
Given an array of n integers where each value represents the number of chocolates in a packet. 
Each packet can have a variable number of chocolates. 
There are m students, the task is to distribute chocolate packets such that: 

Each student gets one packet.
The difference between the number of chocolates in the packet with maximum chocolates 
and packet with minimum chocolates given to the students is minimum.

Examples:

Input : arr[] = {7, 3, 2, 4, 9, 12, 56} , m = 3 
Output: Minimum Difference is 2 

Explanation:
We have seven packets of chocolates and 
we need to pick three packets for 3 students 
If we pick 2, 3 and 4, we get the minimum 
difference between maximum and minimum packet 
sizes.

Input : arr[] = {3, 4, 1, 9, 56, 7, 9, 12} , m = 5 
Output: Minimum Difference is 6 

Explanation:
The set goes like 3,4,7,9,9 and the output 
is 9-3 = 6

Input : arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 
30, 40, 28, 42, 30, 44, 48, 
43, 50} , m = 7 
Output: Minimum Difference is 10 

Explanation:
We need to pick 7 packets. We pick 40, 41, 
42, 44, 48, 43 and 50 to minimize difference 
between maximum and minimum. 

*/
public class Chocolate_Distribution {
    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;
        // int[] arr = {3, 4, 1, 9, 56, 7, 9, 12};  
        // int m = 5;
        // int[] arr = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        // int m = 7;
        int result = solve(arr, m);
        System.out.println(result);
    }

    public static int solve(int[] arr, int m) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = m - 1 ; i < arr.length ; i++) {
            min = Math.min(min, arr[i] - arr[i - (m - 1)]);
        }

        return min;
    }
}
