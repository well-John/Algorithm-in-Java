package recursion;

public class Factorial {

    public static int fn(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return fn(n - 1) * n;
    }

    public static void main(String[] args) {

        int fn = fn(5);
        System.out.println("fn = " + fn);
    }

}
