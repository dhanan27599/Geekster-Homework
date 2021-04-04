package Arrays;
import java.util.*;
/*
Given arrival and departure times of all trains that reach a railway station, 
the task is to find the minimum number of platforms required for the railway station so that no train waits. 
We are given two arrays which represent arrival and departure times of trains that stop.

Examples: 

Input: arr[] = {900, 940, 950, 1100, 1500, 1800} 
dep[] = {910, 1200, 1120, 1130, 1900, 2000} 
Output: 3 
Explantion: There are at-most three trains at a time (time between 11:00 to 11:20)

Input: arr[] = {900, 940} 
dep[] = {910, 1200} 
Output: 1 
Explantion: Only one platform is needed. 

*/
public class Min_Platform {
    public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
        // int arrival[] = {900, 940}, departure[] = {910, 1200}; 
        int result = solve(arrival, departure);
        System.out.println(result);
    }

    public static int solve(int[] arrival, int[] departure) {
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int platform = 1;
        int result = 1;
        int i = 1;
        int j = 0;
        while(i < arrival.length && j < departure.length) {
            int a = arrival[i];
            int b = departure[j];
            if(a <= b) {
                platform += 1;
                i++;
            } else if(a > b) {
                platform -= 1;
                j++;
            }
            result = Math.max(result, platform);
        }
        return result;
    }
}
