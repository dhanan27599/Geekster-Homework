package Arrays;

/*
Given an array and a range [lowVal, highVal], 
partition the array around the range such that array is divided in three parts.

1) All elements smaller than lowVal come first.
2) All elements in range lowVal to highVVal come next.
3) All elements greater than highVVal appear in the end.

The individual elements of three sets can appear in any order.

*/

public class Three_Way_Partitioning {
    public static void main(String[] args) {
        int[] arr = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
        int lowVal = 14, highVal = 20;
        solve(arr, lowVal, highVal);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void solve(int[] arr, int lowVal, int highVal) {
        // int i = 0;
        // //! First Pass -> less than low value
        // for(int j = 0 ; j < arr.length ; j++) {
        //     if(arr[j] < lowVal) {
        //         i++;
        //         swap(arr, i, j);
        //     }
        // }

        // //! Second Pass -> Between low and high 
        // for(int j = 0 ; j < arr.length ; j++) {
        //     if(arr[j] >= lowVal && arr[j] <= highVal) {
        //         i++;
        //         swap(arr, i, j);
        //     }
        // }

        // //!Third Pass -> Greater than high value
        // for(int j = 0 ; j < arr.length ; j++) {
        //     if(arr[j] > highVal) {
        //         i++;
        //         swap(arr, i, j);       
        //     }
        // }
        int start = 0;
        int end = arr.length - 1;
        for(int i = 0 ; i <= end ;) {
            if(arr[i] < lowVal) {
                swap(arr, i++, start++);
            } else if(arr[i] > highVal) {
                swap(arr, i, end--);
            } else {
                i++;
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
