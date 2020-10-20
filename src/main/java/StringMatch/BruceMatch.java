package StringMatch;

/**
 * 字符串匹配算法-暴力匹配
 */
public class BruceMatch {


    /**
     * asdf
     * asef
     *
     * @param s
     * @param p
     * @return
     */
    public static int match(String s, String p) {
        int slen = s.length();
        int plen = p.length();

        int i = 0, j = 0;
        while (i < slen && j < plen) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == plen) {
            return i - j;
        }
        return -1;
    }

    public static void main(String[] args) {
        int match = match("abbbsssa", "sa");
        System.out.println(match);

    }
}
