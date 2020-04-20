package xy.algorithm.leetcode.day_04;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Island {

    /**
     * 方法一：深度优先遍历
     */

        //           x-1,y
        //  x,y-1    x,y      x,y+1
        //           x+1,y
        // 方向数组，它表示了相对于当前位置的 4 个方向的横、纵坐标的偏移量，这是一个常见的技巧
        private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        // 标记数组，标记了 grid 的坐标对应的格子是否被访问过
        private boolean[][] marked;
        // grid 的行数
        private int rows;
        // grid 的列数
        private int cols;
        private char[][] grid;

        public int numIslands(char[][] grid) {
            rows = grid.length;
            if (rows == 0) {
                return 0;
            }
            cols = grid[0].length;
            this.grid = grid;
            marked = new boolean[rows][cols];
            int count = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // 如果是岛屿中的一个点，并且没有被访问过
                    // 就进行深度优先遍历
                    if (!marked[i][j] && grid[i][j] == '1') {
                        count++;
                        dfs(i, j);
                    }
                }
            }
            return count;
        }

        // 从坐标为 (i,j) 的点开始进行深度优先遍历
        private void dfs(int i, int j) {
            marked[i][j] = true;
            // 得到 4 个方向的坐标
            for (int k = 0; k < 4; k++) {
                int newX = i + directions[k][0];
                int newY = j + directions[k][1];
                // 如果不越界、没有被访问过、并且还要是陆地
                if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                    dfs(newX, newY);
                }
            }
        }

        // 封装成 inArea 方法语义更清晰
        private boolean inArea(int x, int y) {
            // 等于号不要忘了
            return x >= 0 && x < rows && y >= 0 && y < cols;
        }

        public static void main(String[] args) {
            Island solution = new Island();
            char[][] grid1 = {
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '0', '1', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '0', '0', '0'}};
            int numIslands1 = solution.numIslands(grid1);
            System.out.println(numIslands1);

            char[][] grid2 = {
                    {'1', '1', '0', '0', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '1', '0', '0'},
                    {'0', '0', '0', '1', '1'}};
            int numIslands2 = solution.numIslands(grid2);
            System.out.println(numIslands2);
        }
    //TODO 递归
}
