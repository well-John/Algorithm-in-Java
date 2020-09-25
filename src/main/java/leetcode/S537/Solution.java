package leetcode.S537;

public class Solution {

    // (1+i)*(-3-i) =
    public String complexNumberMultiply(String a, String b) {
        String[] array_a = a.replaceAll("i","").split("\\+");
        String[] array_b = b.replaceAll("i","").split("\\+");

        int[] operator = new int[4];
        int idx = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int data = Integer.valueOf(array_a[i]) * Integer.valueOf(array_b[j]);
                operator[idx++] = data;
            }
        }

        int op = operator[0]  -operator[3];
        int ip = operator[1] + operator[2];
        return new StringBuilder().append(op).append("+").append(ip).append("i").toString();
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        String s = solution.complexNumberMultiply("1+-1i", "1+-1i");
        System.out.println(s);
    }
}
