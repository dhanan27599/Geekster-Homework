package Arrays;
import java.util.*;
/*
Given a square matrix, 
turn it by 90 degrees in anti-clockwise direction without using any extra space.

Examples :

Input:
Matrix:
1  2  3
4  5  6
7  8  9
Output:
 3  6  9 
 2  5  8 
 1  4  7 
The given matrix is rotated by 90 degree 
in anti-clockwise direction.

Input:
1  2  3  4 
5  6  7  8 
9 10 11 12 
13 14 15 16 
Output:
 4  8 12 16 
 3  7 11 15 
 2  6 10 14 
 1  5  9 13
The given matrix is rotated by 90 degree 
in anti-clockwise direction.

*/

public class Rotate_Square_Matrix_90_Degree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][] result = solve(matrix);
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    public static int[][] solve(int[][] matrix) {
        int prevCol = matrix.length - 2;
        int nextRow = 1;
        int row = 0;
        int col = matrix.length - 1;
        for(int i = matrix.length - 1 ; i >= 1 ; i--) {
            int j = prevCol;
            int k = nextRow;
            while(j >= 0 && k < matrix.length) {
                swap(matrix, row, col, j, k);
                j--;
                k++;
            }
            row += 1;
            col -= 1;
            prevCol -= 1;
            nextRow += 1;
        }
        for(int[] arr : matrix) {
            reverse(arr);
        }

        return matrix;
    }

    private static void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swap(int[][] matrix, int row, int col, int j, int k) {
        int temp1 = matrix[row][j];
        int temp2 = matrix[k][col];
        matrix[row][j] = temp2;
        matrix[k][col] = temp1;
    }
}