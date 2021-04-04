package Arrays;
import java.util.*;
/*

Equilibrium index of an array is an index such that the sum of elements at lower indexes 
is equal to the sum of elements at higher indexes. For example, in an array A: 

Example : 
Input: A[] = {-7 1 5 2 -4 3 0} 
Output: 3 

3 is an equilibrium index, because: 
A[0] + A[1] + A[2] = A[4] + A[5] + A[6]

Input: A[] = {1 2 3} 
Output: -1 

Write a function int equilibrium(int[] arr, int n); 
that given a sequence arr[] of size n, returns an equilibrium index (if any) 
or -1 if no equilibrium indexes exist. 

*/
public class Equillibrium_Index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        int result = solve(arr);
        System.out.println(result);
        sc.close();
    }

    public static int solve(int[] arr) {
        // int[] prefix = new int[arr.length];
        // prefix[0] = arr[0];
        // for(int i = 1 ; i < prefix.length ; i++) {
        //     prefix[i] = prefix[i - 1] + arr[i];
        // }
        // int[] suffix = new int[arr.length];
        // suffix[suffix.length - 1] = arr[arr.length - 1];
        // for(int i = suffix.length - 2 ; i >= 0 ; i--) {
        //     suffix[i] = suffix[i + 1] + arr[i];
        // }

        int totalSum = 0;
        int currentSum = arr[0];
        for(int i : arr) {
            totalSum += i;
        } 
        int i = 1;
        int j = arr.length - 2;
        while(i <= j) {
            if((currentSum + arr[i]) == (totalSum + arr[j])) {
                return i + 1;
            } else {
                currentSum += arr[i++];
                totalSum += arr[j--];
            }
        }
        return -1;
    }
    
}
