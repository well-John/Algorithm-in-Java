package leetcode.S1079;

public class Solution {

    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (int i = 0; i < tiles.length(); i++) {
            count[tiles.charAt(i) - 'A']++;
        }
        return dfs(count);
    }

    private int dfs(int[] counter) {
        int sum = 0;

        for (int i = 0; i < 26; i++) {
            if (counter[i] > 0) {
                sum++;
                counter[i]--;
                sum+=dfs(counter);
                counter[i]++;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int numTilePossibilities = solution.numTilePossibilities("AAABBC");
        System.out.println(numTilePossibilities);


    }

}

