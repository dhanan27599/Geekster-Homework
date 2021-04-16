package Arrays;

/*
An array contains both positive and negative numbers in random order. 
Rearrange the array elements so that positive and negative numbers are placed alternatively. 
Number of positive and negative numbers need not be equal. 
If there are more positive numbers they appear at the end of the array. 
If there are more negative numbers, they too appear in the end of the array.

For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], 
then the output should be [4, -3, 5, -1, 6, -7, 2, 8, 9]
*/

public class Rearrange_Positive_Negative_Number {
    public static void main(String[] args) {
        int[] arr = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        solve(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
    
    public static void solve(int[] arr) {
        int i = -1;
        for(int j = 0 ; j < arr.length ; j++) {
            if(arr[j] < 0) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int pos = i + 1;
        int neg = 0;

        while(pos < arr.length && neg < pos && arr[neg] < 0) {
            int temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos += 1;
            neg += 2;
        }
    }
}
