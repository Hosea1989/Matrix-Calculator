/*
 * Assignment 7
 * Description: This is the Matric Calc. Doing math operations on 2D arrays.
 * Name: Damien Hosea
 * ID: 921395901
 * Class: CSC 210-07
 * Semester: Fall
 */


import java.util.Scanner;

public class MatrixCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] M1, M2, M3; // We are creating three - 2 dimensional arrays
        System.out.print("Please enter the row and column of matrix 1 (n m):");
        int n = input.nextInt();
        int m = input.nextInt();
        M1 = new int[n][m];
        receiveValues(M1, input);
        printM(M1);

        System.out.print("Please enter the row and column of matrix 2 (n m):");
        n = input.nextInt();
        m = input.nextInt();
        M2 = new int[n][m];
        /*           ^^^ Once n and m have been entered, create a 2 dimensional
         - array with
         - n = row
         - m = column
         */

        receiveValues(M2, input);
        printM(M2);

        System.out.print("Please enter the operation between M1 and M2 (*, +, -):");
        char op = input.next().charAt(0);
        switch(op) { //This is a switch statement for each option in the program.
            case '+':
                M3 = new int[M1.length][M2[0].length];
                add(M1, M2, M3);
                printM(M3);
                break;
            case '-':
                M3 = new int[M1.length][M2[0].length];
                subtract(M1, M2, M3);
                printM(M3);
                break;
            case '*':
                if (M1[0].length == M2.length) { //If the dimensions of the two 2D arrays are the same.
                    M3 = new int[M1.length][M2[0].length];
                    mult(M1, M2, M3);
                    printM(M3);
                    break;
                }
                else
                    System.out.println("Matrix dimensions don't match for multiplication.");
                break;
        }

    }

    // The receiveValues method
    public static void receiveValues(int [][] matrix, Scanner input) {
        System.out.print("Please enter " + (matrix.length * matrix[0].length) + " integers:");
        //
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                /* The first for loop will step through each element of the entire 2D array, as long i is less than
                the length of the entire 2D array.

                Know that a multi-dimensional array is just a bunch of 1D array arrays. So that is why the second
                for loop (matrix[0].length) contains a 0 in it's brackets. We are only want to refer to the length of
                the first array.
                 */
                matrix[i][j] = input.nextInt();
    }

    // The add Method
    //In this method, the two 2D array elements are being added together and being passed to the m3 2D array.
    public static void add(int [][] m1, int [][] m2, int [][] m3) {
        for (int i = 0; i < m1.length; i++)
            for (int j = 0; j < m1[0].length; j++)
                m3[i][j] = m1[i][j] + m2[i][j];
    }

    //The subtract Method
    public static void subtract(int [][] m1, int [][] m2, int [][] m3) {
        for (int i = 0; i < m1.length; i++)
            for ( int j = 0; j < m1[0].length; j++)
                m3[i][j] = m1[i][j] - m2[i][j];
    }

    //The multiply Method
    public static void mult(int [][] m1, int [][] m2, int [][] m3) {
        //I placed the length of the 3 2D arrays into their own variables to deal with the
        //out of bounds error.
        int m = m1.length;
        int n = m2[0].length;
        int o = m3[0].length;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                for (int k = 0; k < o; k++) {

                    m3[i][j] = m3[i][j] + m1[i][k] * m2[k][j];
                }
            }
        }

    }

    //The print Method
    public static void printM(int [][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
    }
}