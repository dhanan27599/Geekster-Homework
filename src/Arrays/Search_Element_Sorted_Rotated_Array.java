package Arrays;
/*
An element in a sorted array can be found in O(log n) time via binary search. 
But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand.
So for instance, 1 2 3 4 5 might become 3 4 5 1 2. 
Devise a way to find an element in the rotated array in O(log n) time.

Example:

Input  : 
arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
key = 3
Output : Found at index 8

Input  : 
arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
key = 30
Output : Not found

Input : 
arr[] = {30, 40, 50, 10, 20}
key = 10   
Output : Found at index 3

*/
public class Search_Element_Sorted_Rotated_Array {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;
        int result = solve(arr, key);
        System.out.println(result);
    }

    public static int solve(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == key) {
                return mid;
            }
            if(arr[mid] >= arr[left]) {
                if(key >= arr[left] && key <= arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(key >= arr[mid] && key <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
