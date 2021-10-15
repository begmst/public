import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task03MatrixDiagonal {
    public static void main(String[] args) {
        System.out.println("1. Принимает двумерный (квадратный) массив интов, возвращает сумму диалогалей");
        int sum;
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        sum = getMatrixDiagonalSum(matrix);
        print2DArray(matrix);
        System.out.println(String.format("Sum of diagonals: %d", sum));
        int[][] matrix2 = {
                {1, 2},
                {4, 5},
        };
        sum = getMatrixDiagonalSum(matrix2);
        print2DArray(matrix);
        System.out.println(String.format("Sum of diagonals: %d", sum));
        System.out.println();

        System.out.println("2. Принимает двумерный массив long и двумерный массив булеан, возвращает одномерный массив лонгов который состоит из элементов первого массива. По индексам по которым в массиве булеан хранятся значения тру.");
        long[][] longArray = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        };
        boolean[][] boolArray = {
            {true, false, false},
            {true, true, true},
            {false, true, true},
        };
        long[] resultArray = getValidLongValues(longArray, boolArray);
        print2DArray(longArray);
        print2DArray(boolArray);
        System.out.println(String.format("Result values: %s", Arrays.toString(resultArray)));
        System.out.println();

        System.out.println("3. Принимает двумерный массив символов - выводит его на экран.");
        char[][] charArray = {
            {'q', 'W', 'e'},
            {'A', 'S', 'D'},
            {'z', 'x', 'c'},
        };
        print2DArray(charArray);
        System.out.println();
    }

    public static int getMatrixDiagonalSum(int[][] matrix) {
        int N = matrix.length;
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += matrix[i][i] + matrix[i][N - i - 1];
        }
        if (N % 2 != 0) {
            result -= matrix[N / 2][N / 2];
        }
        return result;
    }

    public static long[] getValidLongValues(long[][] longArray, boolean[][] boolArray) {
        List<Long> list = new ArrayList<Long>();
        for (int i = 0; i < longArray.length; i++) {
            for (int j = 0; j < longArray.length; j++) {
                if (boolArray[i][j]) {
                    list.add(longArray[i][j]);
                }
            }
        }
        return list.stream().mapToLong(x -> x).toArray();
    }

    public static void print2DArray(int[][] matrix) {
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
    }

    public static void print2DArray(char[][] matrix) {
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
    }

    public static void print2DArray(long[][] matrix) {
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
    }

    public static void print2DArray(boolean[][] matrix) {
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
    }
}
