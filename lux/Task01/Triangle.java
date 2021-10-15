public class Triangle {
    public static void main(String[] args) {
        variant1();
        System.out.println();
        System.out.println();
        System.out.println();
        variant2();
    }

    public static void variant1() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i <= j) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i >= j) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i <= j) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i + j >= 4) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    protected static String leftRotate(String str, int d) {
        String ans = str.substring(d) + str.substring(0, d);
        return ans;
    }

    static String rightRotate(String str, int d) {
        return leftRotate(str, str.length() - d);
    }

    public static void variant2() {
        int N = 5;
        StringBuilder sourceString = new StringBuilder("  ".repeat(N) + "* ".repeat(N));
        while (true) {
            for (int i = 0; i < (N - 0) * 2 - 1; i++) {
                sourceString = new StringBuilder(rightRotate(sourceString.toString(), 2));
                System.out.println(sourceString.substring(0, N * 2));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("123123");
            sourceString = new StringBuilder(leftRotate(sourceString.toString(), 2));
//            sourceString = new StringBuilder(leftRotate(sourceString.toString(), 2));
            for (int i = 0; i < (N - 0) * 2; i++) {
                sourceString = new StringBuilder(leftRotate(sourceString.toString(), 2));
                System.out.println(sourceString.substring(0, N * 2));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}