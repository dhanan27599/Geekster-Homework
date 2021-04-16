package Arrays;
import java.util.*;
/*
Given an unsorted array and a number n, 
find if there exists a pair of elements in the array whose difference is n.

Examples:
Input: arr[] = {5 20 3 2 50 80}, n = 78
Output: Pair Found: (2, 80)

Input: arr[] = {90 70 20 80 50}, n = 45
Output: No Such Pair
*/
public class Pair_Given_Difference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        pair result = solve(arr, target);
        String res = !result.toString().equals("[-1, -1]") ? result.toString() : "No Pairs Found";
        System.out.println(res);
        sc.close();
    }

   private static pair solve(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr) {
            if(set.contains(i)) {
                return new pair(Math.abs(target - i), i);
            }
            set.add(target + i);
        }

        return new pair(-1, -1);
        /**
         * 
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        while(i < arr.length && j < arr.length) {
            if(i != j && arr[j] - arr[i] == target) {
                return new pair(arr[i], arr[j]);
            } else if(arr[j] - arr[i] < target) {
                j++;
            } else {
                i++;
            }
        }

        return new pair(-1, -1);
         */
    }

    static class pair {
        int a;
        int b;
        public pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return new StringBuilder("[" + a + ", " + b + "]").toString();
        }
    }
}