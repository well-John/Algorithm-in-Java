package recursion;


import java.util.Arrays;

public class Permutation {

    private int[] data;

    private int length;


    public Permutation(int length) {
        this.length = length;
        data = new int[length];
        for (int i = 0; i < length; i++) {
            data[i] = i + 1;
        }
    }

    public void handler(int start) {
        if (start == length - 1) {
            System.out.println(Arrays.toString(data));
        } else {
            for (int i = start; i < length; i++) {
                int temp = data[start];
                data[start] = data[i];
                data[i] = temp;
                handler(start + 1);
                temp = data[start];
                data[start] = data[i];
                data[i] = temp;
            }

        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation(5);
        permutation.handler(0);


    }


}
