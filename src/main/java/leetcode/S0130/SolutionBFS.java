package leetcode.S0130;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionBFS {
    class Position {
        int i;
        int j;

        public Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }


    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    bfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }


    }

    public void bfs(char[][] board, int i, int j) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(i, j));
        board[i][j] = '#';

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            //上
            if (current.i - 1 >= 0 && board[current.i - 1][current.j] == 'O') {
                queue.offer(new Position(current.i - 1, current.j));
                board[current.i-1][current.j] = '#';
            }
            //下
            if (current.i + 1 < board.length && board[current.i +1][current.j] == 'O') {
                queue.offer(new Position(current.i + 1, current.j));
                board[current.i+1][current.j] = '#';
            }
            //左
            if (current.j - 1 >= 0 && board[current.i][current.j-1] == 'O') {
                queue.offer(new Position(current.i, current.j-1));
                board[current.i][current.j-1] = '#';
            }
            //右
            if (current.j + 1 >= 0 && board[current.i][current.j+1] == 'O') {
                queue.offer(new Position(current.i, current.j+1));
                board[current.i][current.j+1] = '#';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };


        SolutionBFS solution = new SolutionBFS();
        solution.solve(board);

        System.out.println(Arrays.deepToString(board));


    }
}
