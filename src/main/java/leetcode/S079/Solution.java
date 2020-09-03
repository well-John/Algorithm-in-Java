package leetcode.S079;

/**
 * 79.单词搜索
 */
public class Solution {

    private boolean[][] mark;


    public boolean exist(char[][] board, String word) {
        mark = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int index) {
        if (i < 0 || i >= board.length || j >= board[0].length || j < 0 ||
                board[i][j] != word.charAt(index) || mark[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }

        mark[i][j] = true;

        boolean dfs_right = dfs(i + 1, j, board, word, index + 1);
        boolean dfs_left = dfs(i - 1, j, board, word, index + 1);
        boolean dfs_down = dfs(i, j + 1, board, word, index + 1);
        boolean dfs_up = dfs(i, j - 1, board, word, index + 1);
        boolean flag = dfs_right || dfs_left || dfs_down || dfs_up;
        if (flag) {
            return true;
        }
        mark[i][j] = false;
        return false;
    }


    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        Solution solution = new Solution();
        boolean exist = solution.exist(board, "ABCCED");
        System.out.println(exist);


    }


}
