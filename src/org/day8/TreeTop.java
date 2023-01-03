package org.day8;

import java.util.Arrays;

public class TreeTop {
    public static void main(String[] args) {

        int matrix[][] = new int[][]{ {3,0,3,7,3}, {2,5,5,1,2} ,{6,5,3,3,2},{3,3,5,4,9},{3,5,3,9,0}};
        System.out.println("The Original Matrix is: ");
        printMatrix(matrix);
        tree(matrix);
        rightRotate(matrix);
        System.out.println("The Right Rotated Matrix is: ");
        printMatrix(matrix);
        //tree(matrix);
    }
    static void rightRotate(int matrix[][]) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            int low = 0, high = n - 1;
            while (low < high) {
                int temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                low++;
                high--;
            }
        }
    }
    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " " + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void tree(int matrix[][]) {
        int[] rowArray = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            int index = 0;
            for (int column = 0; column < matrix[row].length; column++) {
                rowArray[index] = matrix[row][column];
                index++;
                }
            System.out.println("fff" + Arrays.toString(rowArray));
            getRange(rowArray);
            }
        }
    public static void getRange (int[] row) {
        int index = 0;
        int currentMaxItem = row[0];
        while (index < row.length) {
            if (row[index] >= currentMaxItem) {
                currentMaxItem = row[index];
                System.out.println(currentMaxItem);
            }
            index++;
        }
    }
}

