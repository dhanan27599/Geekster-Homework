package Arrays;
/*
You are given an array of 0s and 1s in random order. 
Segregate 0s on left side and 1s on right side of the array. Traverse array only once. 
 
Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0] 
Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1] 
 */
public class Segregate_01 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        solve(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }


    public static void solve(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        for(int i = 0 ; i <= end ;) {
            if(arr[i] == 0) {
                swap(arr, i, start);
                i++;
                start++;
            } else if(arr[i] == 1) {
                swap(arr, i, end);
                end--;
            }
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
