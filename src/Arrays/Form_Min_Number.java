package Arrays;

import java.util.*;

/*
Given a pattern containing only I’s and D’s.
I for increasing and D for decreasing.
Devise an algorithm to print the minimum number following that pattern.
Digits from 1-9 and digits can’t repeat.

Examples:
   Input: D        Output: 21
   Input: I        Output: 12
   Input: DD       Output: 321
   Input: II       Output: 123
   Input: DIDI     Output: 21435
   Input: IIDDD    Output: 126543
   Input: DDIDDIID Output: 321654798

   Also number of digits in output is one more than number of characters in input.
   Note that the first character of input corresponds to two digits in output.
   Idea is to iterate over input array and keep track of
   last printed digit and maximum digit printed so far.
   Below is the implementation of above idea.

 */
public class Form_Min_Number {
    public static void main(String[] args) {
        String s = new Scanner(System.in).next();
        System.out.println(solve(s));
    }

    public static String solve(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i <= s.length() ; i++) {
            stack.push(i + 1);

            if(i == s.length() || s.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }
        return sb.toString();
    }
}
