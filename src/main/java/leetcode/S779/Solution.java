package leetcode.S779;

public class Solution {
    // 0
    // 0 ->01
    // 01-> 0110
    // 01101001
    public int kthGrammar(int N, int K) {
        if(K == 1)
            return 0;
        if(K % 2 == 0) {
            return Math.abs(kthGrammar(N-1, K/2) - 1);
        }
        else {
            return kthGrammar(N-1, (K+1)/2);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int grammar = solution.kthGrammar(3, 3);
        System.out.println(grammar);
    }
}
