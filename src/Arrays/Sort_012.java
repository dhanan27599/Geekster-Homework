package Arrays;
/*
Given an array A[] consisting 0s, 1s and 2s. 
The task is to write a function that sorts the given array. 
The functions should put all 0s first, 
then all 1s and all 2s in last.
Examples: 
 

Input: {0, 1, 2, 0, 1, 2}
Output: {0, 0, 1, 1, 2, 2}

Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 */
public class Sort_012 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        solve(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void solve(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        for(int i = 0 ; i <= end ; ) {
            if(arr[i] < 1) {
                swap(arr, i++, start++);
            } else if(arr[i] > 1) {
                swap(arr, i, end--);
            } else {
                i++;
            }
        }
    }    

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
