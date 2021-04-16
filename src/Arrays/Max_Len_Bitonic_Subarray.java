package Arrays;
// Given an array arr[0 … n-1] containing n positive integers, 
// a subarray arr[i … j] is bitonic if there is a k with i <= k <= j 
// such that arr[i] <= arr[i + 1] … = arr[k + 1] >= .. arr[j – 1] > = arr[j]. 
// Write a function that takes an array as argument and 
// returns the length of the maximum length bitonic subarray.
// Expected time complexity of the solution is O(n)

// Simple Examples"
// 1) arr[] = {12, 4, 78, 90, 45, 23}, the maximum length bitonic subarray is {4, 78, 90, 45, 23} which is of length 5.

// 2) arr[] = {20, 4, 1, 2, 3, 4, 2, 10}, the maximum length bitonic subarray is {1, 2, 3, 4, 2} which is of length 5.

// Extreme Examples:
// 1) arr[] = {10}, the single element is bitnoic, so output is 1.

// 2) arr[] = {10, 20, 30, 40}, the complete array itself is bitonic, so output is 4.

// 3) arr[] = {40, 30, 20, 10}, the complete array itself is bitonic, so output is 4.


public class Max_Len_Bitonic_Subarray {
    public static void main(String[] args) {
        int[] arr = {40, 30, 20, 10};
        int result = solve(arr);
        System.out.println(result);        
    }

    public static int solve(int[] arr) {
        // if(arr.length == 0 || arr.length == 1) {
        //     return arr.length;
        // }
        // int len = 1;
        // int maxLen = 1;
        // boolean flag = false;
        // for(int i = 1 ; i < arr.length ; i++) {
        //     if(i == 1) {
        //         if(arr[i] > arr[i - 1]) {
        //             flag = true;
        //         }
        //         len += 1;
        //     } else if(i == arr.length - 1) {
        //         if(flag && arr[i] > arr[i - 1] || !flag && arr[i] < arr[i - 1]) {
        //             len += 1;
        //         } else {
        //             len = 1;
        //         }
        //         maxLen = Math.max(maxLen, len);
        //         break;
        //     } else if(!flag && arr[i] > arr[i - 1]) {
        //         len = 2;
        //         flag = true;
        //     } else if(flag && arr[i] < arr[i - 1]) {
        //         len += 1;
        //         flag = false;
        //     } else {
        //         len += 1;
        //     }

        //     maxLen = Math.max(maxLen, len);
        // }
        // return maxLen;

        int n = arr.length;
        if (n == 0) {
			return 0;
        }
      
		int maxLen = 1;
		int start = 0;
		int nextStart = 0;
		int j = 0;
      
		while (j < n-1) {	
			while (j < n-1 && arr[j] <= arr[j+1]) {
				j++;
            }
			while (j < (n - 1) && arr[j] >= arr[j + 1]) {
				if (j < (n - 1) && arr[j] > arr[j + 1]){
					nextStart = j + 1;
                }
				j++;
			}
          
			maxLen = Math.max(maxLen, j - (start - 1));
			start = nextStart;
		}
      
		return maxLen;
    }
}
