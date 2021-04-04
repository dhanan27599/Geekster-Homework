package Arrays;
/*
Given a set of time intervals in any order, 
merge all overlapping intervals into one and 
output the result which should have only mutually exclusive intervals. 
Let the intervals be represented as pairs of integers for simplicity. 
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8}}. 
The intervals {1,3} and {2,4} overlap with each other, 
so they should be merged and become {1, 4}. 
Similarly, {5, 7} and {6, 8} should be merged and become {5, 8}
 */
import java.util.*;
public class Merge_Overlapping_Intervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,4}, {5,7}, {6,8}};
        // int[][] intervals = {{6, 8}, {1, 9}, {2, 4}, {4, 7}};
        List<int[]> result = solve(intervals);
        for(int[] arr : result) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<int[]> solve(int[][] intervals) {
        Arrays.sort(intervals, (arr1, arr2) -> (arr1[0] - arr2[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int[] current = result.get(0);
        for(int[] interval : intervals) {
            int ce = current[1];
            int ns = interval[0];
            int ne = interval[1];
            if(ce >= ns ) {
                current[1] = Math.max(ce, ne);
            } else {
                current = interval;
                result.add(current);
            }
        }
        return result;
    }

    
}
