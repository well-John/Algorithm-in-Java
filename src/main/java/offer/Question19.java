package offer;

public class Question19 {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int row = s.length();
        int column = p.length();
        boolean[][] dp = new boolean[row + 1][column + 1];
        dp[0][0] = true;

        for (int j = 1; j <= column; j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }


        for (int i = 1; i <= row; i++) {

            for (int j = 1; j <= column; j++) {
                char nows = s.charAt(i-1);
                char nowp = p.charAt(j-1);
                if (nows == nowp) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (nowp == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (nowp == '*') {
                        if (j >= 2) {
                            char nowplast = p.charAt(j - 2);
                            if (nowplast == nows || nowplast == '.') {
                                dp[i][j] = dp[i][j - 1] | dp[i - 1][j];
                            }

                            dp[i][j] = dp[i][j] | dp[i][j - 2];
                        }

                    } else {
                        dp[i][j] = false;
                    }
                }

            }

        }
        return dp[row][column];
    }


    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";

        Question19 question19 = new Question19();
        boolean match = question19.isMatch(s, p);
        System.out.println(match);


    }
}
