import java.util.ArrayList;
import java.util.stream.IntStream;

public class Task01DoorLock {

    public static void main(String[] args) {
        System.out.println("Door lock:");
        doorLock();
    }

    public static void doorLock() {
        int[][] sourceMatrix = {
            {0, 1, 1, 0},
            {1, 1, 1, 1},
            {0, 0, 1, 0},
            {1, 0, 1, 0}
        };

        DoorLock lock = new DoorLock(sourceMatrix);
        lock.show();
        ArrayList<ArrayList<Integer>> moves = lock.solve();
        StringBuilder output = new StringBuilder("");
        for (ArrayList<Integer> move : moves) {
            output.append(String.format("(%d, %d) ", move.get(0), move.get(1)));
        }
        System.out.println(String.format("Solution: %s", output));
        lock.show();
    }
}

class DoorLock {
    protected Matrix matrix;

    public DoorLock(int[][] matrix) {
        this.matrix = new Matrix(matrix);
    }

    public void show() {
        this.matrix.show();
    }

    public void change(int row, int col) {
        this.matrix.change(row, col);
        System.out.println(this.matrix.check());
    }

    public ArrayList<ArrayList<Integer>> solve() {
        ArrayList<ArrayList<Integer>> moves = new ArrayList<ArrayList<Integer>>();
        int N = this.matrix.getSize();
        boolean nextStep = !this.matrix.check();
        while (nextStep) {
            Matrix currentMatrix = new Matrix(this.matrix);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (! currentMatrix.get(i, j)) {
                        ArrayList<Integer> move = new ArrayList<>(2);
                        move.add(i);
                        move.add(j);
                        moves.add(move);
                        this.matrix.change(i, j);
                        this.show();
                    }
                }
            }
            if (this.matrix.check()) {
                nextStep = false;
            }
        }
        return moves;
    }
}

class Matrix {
    private boolean[][] matrix;
    private int N;

    public Matrix(Matrix matrix) {
        this(matrix.N);
        for (int i = 0; i < matrix.N; i++) {
            for (int j = 0; j < matrix.N; j++) {
                this.matrix[i][j] = matrix.matrix[i][j];
            }
        }
    }
    public Matrix(int N) {
        this.N = N;
        this.matrix = new boolean[N][];
        for (int i = 0; i < N; i++) {
            this.matrix[i] = new boolean[N];
        }
    }

    public Matrix(int[][] matrix) {
        this(matrix.length);
        this.set(matrix);
    }

    public int getSize() {
        return this.N;
    }

    public void set(int[][] matrix) {
        for (int i = 0; i < this.N; i++) {
            int ii = i;
            IntStream.range(0, this.N).forEach(j -> this.matrix[ii][j] = matrix[ii][j] != 0);
        }
    }

    public boolean get(int row, int col) {
        return this.matrix[row][col];
    }

    public void show() {
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.N; j++) {
                System.out.print(this.matrix[i][j] ? " - " : " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void change(int row, int col) {
        for (int i = 0; i < this.N; i++) {
            this.matrix[row][i] = !this.matrix[row][i];
            this.matrix[i][col] = !this.matrix[i][col];
        }
        this.matrix[row][col] = !this.matrix[row][col];
        System.out.println(String.format("Change (%d, %d)", row, col));
    }

    public boolean check() {
        boolean result = true;
        int i = 0;
        while (result && (i < N * N)) {
            System.out.println(String.format("Check (%d, %d)", i / N, i % N));
            result &= this.matrix[i / N][i % N];
            i++;
        }
        return result;
    }
}