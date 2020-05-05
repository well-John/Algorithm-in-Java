package leetcode.S1263;

/**
 * 「推箱子」是一款风靡全球的益智小游戏，玩家需要将箱子推到仓库中的目标位置。
 * <p>
 * 游戏地图用大小为 n * m 的网格 grid 表示，其中每个元素可以是墙、地板或者是箱子。
 * <p>
 * 现在你将作为玩家参与游戏，按规则将箱子 'B' 移动到目标位置 'T' ：
 * <p>
 * 玩家用字符 'S' 表示，只要他在地板上，就可以在网格中向上、下、左、右四个方向移动。
 * 地板用字符 '.' 表示，意味着可以自由行走。
 * 墙用字符 '#' 表示，意味着障碍物，不能通行。 
 * 箱子仅有一个，用字符 'B' 表示。相应地，网格上有一个目标位置 'T'。
 * 玩家需要站在箱子旁边，然后沿着箱子的方向进行移动，此时箱子会被移动到相邻的地板单元格。记作一次「推动」。
 * 玩家无法越过箱子。
 * 返回将箱子推到目标位置的最小 推动 次数，如果无法做到，请返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [["#","#","#","#","#","#"],
 * ["#","T","#","#","#","#"],
 *              ["#",".",".","B",".","#"],
 *              ["#",".","#","#",".","#"],
 *              ["#",".",".",".","S","#"],
 *              ["#","#","#","#","#","#"]]
 * 输出：3
 * 解释：我们只需要返回推箱子的次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-move-a-box-to-their-target-location
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    class Position {
        int x;
        int y;

        public Position() {
        }

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Position person = new Position();
        Position box = new Position();
        label:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    person = new Position(i, j);
                }
                if (grid[i][j] == 'B') {
                    box = new Position(i, j);
                }
            }
        }

        int dfs = dfs(box.x, box.y, grid, 0, person);
        return dfs;
    }

    private int dfs(int i, int j, char[][] grid, int step, Position person) {
        int step_left = -1, step_right = -1, step_up = -1, step_down = -1;
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return -1;
        }
        //碰到障碍物返回
        if (grid[i][j] == '#') {
            return -1;
        }
        if (grid[i][j] == '.' || grid[i][j] == 'T' || grid[i][j] == 'B') {
            if (grid[i][j] == 'T') {
                return step;
            }
            //1、人能否移动到箱子的右边进行向左推
            dfs_person(person.x, person.y, i + 1, j, grid);
            if (grid[i + 1][j] == 'S') {
                //空-》人
                grid[i + 1][j] = 'S';
                //人-》空
                grid[person.x][person.y] = '.';
                //箱子是否可以进行向左移动
                if (isCanBoxMove(i - 1, j, grid)) {
                    //空位置 -》 箱子位置
                    grid[i - 1][j] = 'B';
                    //箱子位置 -》人
                    grid[i][j] = 'S';
                    // 人位置 -》空
                    grid[i + 1][j] = '.';
                    step++;
                    step_left = dfs(i - 1, j, grid, step, new Position(i, j));
                    //还原人位置
                    grid[i + 1][j] = 'S';
                    //还原箱子位置
                    grid[i][j] = 'B';
                    //还原空位置
                    grid[i - 1][j] = '.';
                }
                //空-》人
                grid[person.x][person.y] = 'S';
                //人 - 》空
                grid[i + 1][j] = '.';
            }

            //2、人能否移动到箱子的左边边进行向右推
            dfs_person(person.x, person.y, i - 1, j, grid);
            if (grid[i - 1][j] == 'S') {
                //空-》人
                grid[i - 1][j] = 'S';
                //人-》空
                grid[person.x][person.y] = '.';
                //箱子是否可以进行向右移动
                if (isCanBoxMove(i + 1, j, grid)) {
                    //空位置 -》 箱子位置
                    grid[i + 1][j] = 'B';
                    //箱子位置 -》人
                    grid[i][j] = 'S';
                    // 人位置 -》空
                    grid[i - 1][j] = '.';
                    step++;
                    step_right = dfs(i + 1, j, grid, step, new Position(i, j));
                    //还原人位置
                    grid[i - 1][j] = 'S';
                    //还原箱子位置
                    grid[i][j] = 'B';
                    //还原空位置
                    grid[i + 1][j] = '.';
                }
                //空-》人
                grid[person.x][person.y] = 'S';
                //人 - 》空
                grid[i - 1][j] = '.';
            }

            //3、人能否移动到箱子的下边进行向上推
            dfs_person(person.x, person.y, i, j + 1, grid);
            if (grid[i][j + 1] == 'S') {
                //空-》人
                grid[i][j + 1] = 'S';
                //人-》空
                grid[person.x][person.y] = '.';
                //箱子是否可以进行向上移动
                if (isCanBoxMove(i, j - 1, grid)) {
                    //空位置 -》 箱子位置
                    grid[i][j - 1] = 'B';
                    //箱子位置 -》人
                    grid[i][j] = 'S';
                    // 人位置 -》空
                    grid[i][j + 1] = '.';
                    step++;
                    step_up = dfs(i, j - 1, grid, step, new Position(i, j));
                    //还原人位置
                    grid[i][j + 1] = 'S';
                    //还原箱子位置
                    grid[i][j] = 'B';
                    //还原空位置
                    grid[i][j - 1] = '.';
                }
                //空-》人
                grid[person.x][person.y] = 'S';
                //人 - 》空
                grid[i][j + 1] = '.';
            }

            //4、人能否移动到箱子的上边进行向下推
            dfs_person(person.x, person.y, i, j - 1, grid);
            if (grid[i][j - 1] == 'S') {
                //空-》人
                grid[i][j - 1] = 'S';
                //人-》空
                grid[person.x][person.y] = '.';
                //箱子是否可以进行向下移动
                if (isCanBoxMove(i, j + 1, grid)) {
                    //空位置 -》 箱子位置
                    grid[i][j + 1] = 'B';
                    //箱子位置 -》人
                    grid[i][j] = 'S';
                    // 人位置 -》空
                    grid[i][j - 1] = '.';
                    step++;
                    step_up = dfs(i + 1, j, grid, step, new Position(i, j));
                    //还原人位置
                    grid[i][j - 1] = 'S';
                    //还原箱子位置
                    grid[i][j] = 'B';
                    //还原空位置
                    grid[i][j - 1] = '.';
                }
                //空-》人
                grid[person.x][person.y] = 'S';
                //人 - 》空
                grid[i][j + 1] = '.';
            }
        }
        return -1;
    }


    public void dfs_person(int person_x, int person_y, int dest_x, int dest_y, char[][] grid) {
        if (person_x < 0 || person_y < 0 || person_x >= grid.length || person_y >= grid[0].length
                || grid[person_x][person_y] == '#' || grid[person_x][person_y] == 'B') {
            return;
        }
        if (person_x == dest_x && person_y == dest_y) {
            grid[person_x][person_y] = 'S';
            return;
        }
        dfs_person(person_x - 1, person_y, dest_x, dest_y, grid);
        dfs_person(person_x + 1, person_y, dest_x, dest_y, grid);
        dfs_person(person_x, person_y - 1, dest_x, dest_y, grid);
        dfs_person(person_x, person_y + 1, dest_x, dest_y, grid);
    }

    //箱子能否移动到(i,j)这个位置
    public boolean isCanBoxMove(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] == '#' || grid[i][j] == 'S') {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'#', '#', '#', '#', '#', '#'},
                {'#', 'T', '#', '#', '#', '#'},
                {'#', '.', '.', 'B', '.', '#'},
                {'#', '.', '#', '#', '.', '#'},
                {'#', '.', '.', '.', 'S', '#'},
                {'#', '#', '#', '#', '#', '#'}
        };

        Solution solution = new Solution();
        int minPush = solution.minPushBox(grid);
        System.out.println(minPush);

    }
}
