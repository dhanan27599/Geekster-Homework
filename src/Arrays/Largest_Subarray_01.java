package Arrays;

/*
Given an array containing only 0s and 1s, 
find the largest subarray which contains equal no of 0s and 1s. 
The expected time complexity is O(n). 

Examples: 
Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
Output: 1 to 6 
(Starting and Ending indexes of output subarray)

Input: arr[] = {1, 1, 1, 1}
Output: No such subarray

Input: arr[] = {0, 0, 1, 1, 0}
Output: 0 to 3 Or 1 to 4

*/
import java.util.*;
public class Largest_Subarray_01 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 1, 0, 0};
        solve(arr);
    }

    public static int solve(int[] arr) {
        // int zeroes = 0;
        // int ones = 0;
        // for(int i : arr) {
        //     if(i == 0) {
        //         zeroes += 1;
        //     } else {
        //         ones += 1;
        //     }
        // }

        // if(zeroes == 0 || ones == 0) {
        //     System.out.println("No Such Subarray");
        //     return;
        // }
        // if(zeroes == ones) {
        //     System.out.println(0 + " to " + (arr.length - 1));
        //     return;
        // }

        // int zl = zeroes, zr = zeroes, ol = ones, or = ones;
        // int i = 0;
        // int j = arr.length - 1;

        // while(i < j) {
        //     if(arr[i] == 0) {
        //         zl -= 1;
        //         i += 1;
        //     } else {
        //         ol -= 1;
        //         i += 1;
        //     } 
        //     if(zl == ol) {
        //         System.out.println(i + " to " + j);
        //         return;
        //     }
        //     if(arr[j] == 0) {
        //         zr -= 1;
        //         j -= 1;
        //     } else {
        //         or -= 1;
        //         j -= 1;
        //     }
        //     if(zr == or) {
        //         System.out.println(i + " to " + j);
        //         return;
        //     }
        // }
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int sum = 0;
      
		int max_len = 0;
		int ending_index = -1;

		for (int i = 0; i < n; i++) {
			arr[i] = (arr[i] == 0) ? -1 : 1;
		}


		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == 0) {
				max_len = i + 1;
				ending_index = i;
			}
			if (map.containsKey(sum)) {
				if (max_len < i - map.get(sum)) {
					max_len = i - map.get(sum);
					ending_index = i;
				}
			}
			else {
				map.put(sum, i);
            }
		}

		for (int i = 0; i < n; i++) {
			arr[i] = (arr[i] == -1) ? 0 : 1;
		}

		int end = ending_index - max_len + 1;
		System.out.println(end + " to " + ending_index);

		return max_len;
    }
}
