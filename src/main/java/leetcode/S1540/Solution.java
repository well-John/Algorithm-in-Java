package leetcode.S1540;

public class Solution {

    public boolean canConvertString(String s, String t, int k) {
        char[] originArray = s.toCharArray();
        char[] destArray = t.toCharArray();
        if (originArray.length != destArray.length) {
            return false;
        }
        int[] count = new int[26];

        for (int i = 0; i < originArray.length; i++) {
            if (originArray[i] == destArray[i]) {
                continue;
            } else {
                int distance = destArray[i] - originArray[i];
                if (distance < 0) {
                    distance = distance + 26;
                }
                count[distance]++;
            }
        }

        for (int i = 1; i < 26; i++) {
            int max = i + (count[i] - 1) * 26;
            if (max > k) {
                return false;
            }

        }
        return true;
    }

    //"iqssxdlb"  abc
    //"dyuqrwyr"  bcd
    //40          10

    //"mygdwuntwkoc"
    //"btydmdiatnhx"
    //48

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean convertString = solution.canConvertString("mygdwuntwkoc", "btydmdiatnhx", 48);
        System.out.println(convertString);
    }
}
