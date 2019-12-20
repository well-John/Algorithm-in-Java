package leetcode.S012;

/**
 * 12  整数转罗马数字
 */
public class Solution {

    public  String intToRoman(int num) {
        //千位
        int k = num / 1000;
        //百位
        int m = (num - k * 1000) / 100;
        //十位
        int n = (num - k * 1000 - m * 100) / 10;
        //个位
        int l = (num - k * 1000 - m * 100 - n * 10);

        StringBuilder result = new StringBuilder();
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                result.append("M");
            }
        }
        return result.append(getString(m, 3)).append(getString(n, 2)).append(getString(l, 1)).toString();
    }

    // tab 3: 百位 ，2：十位，1：个位
    private  String getString(int m, int tab) {
        StringBuilder result = new StringBuilder();
        if (m > 0) {
            if (m < 5) {
                if (m <= 3) {
                    for (int i = 0; i < m; i++) {
                        if (tab == 3) {
                            result.append("C");
                        } else if (tab == 2) {
                            result.append("X");
                        } else if (tab == 1) {
                            result.append("I");
                        }
                    }
                } else {
                    if (tab == 3) {
                        result.append("CD");
                    } else if (tab == 2) {
                        result.append("XL");
                    } else if (tab == 1) {
                        result.append("IV");
                    }
                }
            } else {
                if (m < 9) {
                    if (tab == 3) {
                        result.append("D");
                    } else if (tab == 2) {
                        result.append("L");
                    } else if (tab == 1) {
                        result.append("V");
                    }
                    for (int i = 0; i < (m - 5); i++) {
                        if (tab == 3) {
                            result.append("C");
                        } else if (tab == 2) {
                            result.append("X");
                        } else if (tab == 1) {
                            result.append("I");
                        }
                    }
                } else if (m == 9) {
                    if (tab == 3) {
                        result.append("CM");
                    } else if (tab == 2) {
                        result.append("XC");
                    } else if (tab == 1) {
                        result.append("IX");
                    }
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().intToRoman(9);
        System.out.println(s);
    }
}
