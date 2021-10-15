public class Task01Triangle {

    public static void main(String[] args) {
        System.out.println("Triangles:");
        triangle(5);
    }

    public static void triangle(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i <= j) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i >= j) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i <= j) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i + j >= (N - 1)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
