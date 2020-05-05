package leetcode.S1263;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution2 {
    private int m;
    private int n;

    public int minPushBox(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int px = 0, py = 0, bx = 0, by = 0, tx = 0, ty = 0, dis = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    px = i;
                    py = j;
                } else if (grid[i][j] == 'B') {
                    bx = i;
                    by = j;
                } else if (grid[i][j] == 'T') {
                    tx = i;
                    ty = j;
                }
            }
        }

        int[] initState = new int[]{0, px, py, bx, by};
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.add(initState);
        HashSet<Integer> visited = new HashSet<>();
        int hash = (px << 18) | (py << 12) | (bx << 6) | by;
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        visited.add(hash);
        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            dis = state[0];
            px = state[1];
            py = state[2];
            bx = state[3];
            by = state[4];
            if (bx == tx && by == ty)
                return dis;
            for (int i = 0; i < dir.length; i++) {
                int npx = px + dir[i][0], npy = py + dir[i][1];
                if (!inArea(npx, npy) || grid[npx][npy] == '#')
                    continue;
                int nbx = bx, nby = by;
                if (npx == bx && npy == by) {
                    if (!inArea(bx + dir[i][0], by + dir[i][1]) || grid[bx + dir[i][0]][by + dir[i][1]] == '#')
                        continue;
                    nbx = bx + dir[i][0];
                    nby = by + dir[i][1];
                    hash = (npx << 18) | (npy << 12) | (nbx << 6) | nby;
                    if (!visited.contains(hash)) {
                        queue.add(new int[]{dis + 1, npx, npy, nbx, nby});
                        visited.add(hash);
                        continue;
                    }
                } else {
                    hash = (npx << 18) | (npy << 12) | (nbx << 6) | nby;
                    if (!visited.contains(hash)) {
                        queue.add(new int[]{dis, npx, npy, nbx, nby});
                        visited.add(hash);
                    }
                }
            }

        }
        return -1;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
