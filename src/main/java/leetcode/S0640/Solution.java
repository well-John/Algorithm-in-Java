package leetcode.S0640;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String solveEquation(String equation) {
        String[] array = equation.split("=");
        int leftVal = 0, rightVal = 0;
        for (String s : breakIt(array[0])) {
            if (s.indexOf("x") >= 0) {
                leftVal += Integer.parseInt(replaceX(s));
            } else {
                rightVal -= Integer.parseInt(s);
            }
        }

        for (String s : breakIt(array[1])) {
            if (s.indexOf("x") >= 0) {
                leftVal -= Integer.parseInt(replaceX(s));
            } else {
                rightVal += Integer.parseInt(s);
            }
        }

        if (leftVal == 0) {

            if (rightVal == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }


        return "x=" + rightVal / leftVal;
    }

    private String replaceX(String s) {
        if (s.length() > 1 && s.charAt(s.length() - 2) >= '0' && s.charAt(s.length() - 2) <= '9') {
            return s.replace("x", "");
        }
        return s.replace("x", "1");
    }


    private List<String> breakIt(String s) {
        List<String> res = new ArrayList<>();
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (tmp.length() > 0) {
                    res.add(tmp);
                }
                tmp = "" + s.charAt(i);
            } else {
                tmp += s.charAt(i);
            }
        }
        res.add(tmp);
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String equation = solution.solveEquation("x=x+1");
        System.out.println(equation);

    }
}
