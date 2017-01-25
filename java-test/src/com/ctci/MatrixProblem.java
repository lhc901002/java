package com.ctci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 1/3/17.
 */
public class MatrixProblem {

    public static int[][] rotateNintyDegree(int[][] matrix) {
        if (matrix == null || matrix.length < 2) {
            return matrix;
        }
        // first round swap: exchange triangle elements
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // second round swap: turn rows upside down
        for (int i = 0; i < matrix.length / 2; i++) {
            int[] tmpArray = matrix[i];
            matrix[i] = matrix[matrix.length - i - 1];
            matrix[matrix.length - i - 1] = tmpArray;
        }
        return matrix;
    }

    public static int[][] zero(int[][] matrix, int rowLength, int columnLength) {
        if (matrix == null || rowLength < 1 || columnLength < 1) {
            return matrix;
        }
        boolean[] row = new boolean[rowLength];
        boolean[] column = new boolean[columnLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    public static int[][] zero2(int[][] matrix, int rowLength, int columnLength) {
        if (matrix == null || rowLength < 1 || columnLength < 1) {
            return matrix;
        }
        // cast zero mark to the first column and first row
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < columnLength; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // set row zero
        for (int i = 0; i < rowLength; i++) {
            if (matrix[i][0] == 0) {
                zeroRow(matrix, i);
            }
        }
        // set column zero
        for (int j = 0; j < columnLength; j++) {
            if (matrix[0][j] == 0) {
                zeroColumn(matrix, j);
            }
        }
        return matrix;
    }

    public static void zeroRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }

    public static void zeroColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    public static void find(int[][] matrix, int rowLength, int columnLength, int value) {
        if (value < matrix[0][0] || value > matrix[rowLength - 1][columnLength - 1]) {
            System.out.println("No such element!");
            return;
        }
        int rowIndexUp = 0, columnIndexLeft = 0;
        int rowIndexDown = rowLength - 1;
        int columnIndexRight = columnLength - 1;
        while (rowIndexUp <= rowIndexDown && columnIndexLeft <= columnIndexRight) {
            // compare with upper right element
            int tmp = matrix[rowIndexUp][columnIndexRight];
            if (value == tmp) {
                System.out.println(rowIndexUp + ", " + columnIndexRight);
                return;
            } else if (value > tmp) {
                rowIndexUp++;
            } else {
                columnIndexRight--;
            }
            // compare with lower left element
            tmp = matrix[rowIndexDown][columnIndexLeft];
            if (value == tmp) {
                System.out.println(rowIndexDown + ", " + columnIndexLeft);
                return;
            } else if (value > tmp) {
                columnIndexLeft++;
            } else {
                rowIndexDown--;
            }
        }
        System.out.println("No such element!");
    }

    public static void printMatrix(int[][] matrix) {
        if (matrix != null) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void printMatrix(int[][] matrix, int rowLength, int columnLength) {
        if (matrix != null) {
            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < columnLength; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            up++;
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[down][i]);
                }
                down--;
            }
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        int[][] matrix2 = {
                {1, 2, 3},
                {3, 7, 8},
                {5, 9, 10},
                {7, 12, 15},
                {7, 12, 15}};
        System.out.println(spiralOrder(matrix));
    }
}
