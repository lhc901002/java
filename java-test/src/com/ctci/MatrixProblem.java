package com.ctci;

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

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {3, 7, 8, 9, 11},
                {5, 9, 10, 17, 18},
                {7, 12, 15, 19, 23},
                {9, 13, 16, 20, 25}};
        find(matrix, 5, 5, 9);   // 4, 0
        find(matrix, 5, 5, 12);  // 3, 1
        find(matrix, 5, 5, 1);   // 0, 0
        find(matrix, 5, 5, 25);  // 4, 4
        find(matrix, 5, 5, 22);  // No such element!
        find(matrix, 5, 5, 26);  // No such element!
        find(matrix, 5, 5, 0);   // No such element!

        int[][] matrix1 = {
                {1, -1, 3, 4, 2},
                {5, 6, 7, 8, 2},
                {9, 10, 0, 12, 2},
                {13, 14, 15, 0, -3}};
        int[][] matrix2 = null;
        int[][] matrix3 = {};
        int[][] matrix4 = {{1}};
//        printMatrix(rotateNintyDegree(matrix1));
//        printMatrix(rotateNintyDegree(matrix2));
//        printMatrix(rotateNintyDegree(matrix3));
//        printMatrix(rotateNintyDegree(matrix4));
//        printMatrix(zero2(matrix1, 4, 5), 4, 5);
//        printMatrix(zero2(matrix2, 0, 0), 0, 0);
//        printMatrix(zero2(matrix3, 0, 0), 0, 0);
//        printMatrix(zero2(matrix4, 1, 1), 1, 1);
    }
}
