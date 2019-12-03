package recursion;

public class Fibonacci {

    public static int fn(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return fn(n - 2) + fn(n - 1);
    }

    public static void main(String[] args) {

        int fn = fn(10);
        System.out.println("fn = " + fn);
    }
}
