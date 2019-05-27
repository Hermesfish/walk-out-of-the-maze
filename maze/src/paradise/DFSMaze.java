public class DFSMaze {

    static String path = "";
    static String shortestPath = "";

    public static void dfsMaze(int x, int y, int[][] maze) {
        /*
         * 获得矩阵的大小
         * */
        int m=maze.length;
        int n=maze[0].length;
        //设置结束条件
        if (x < 0 || y < 0)
            return;
        // 如果坐标越界，或者 maze[x][y]==1 表示遇到障碍
        if (x > m - 1 || y > n - 1 || maze[x][y] ==1)
            return;
        //表示遇到障碍
        if (maze[x][y] == 1)
            return; // 判断是否通路和越界
        if (x == m - 1 && y == n - 1) { // 判断是否抵达出口
            path = path + "(" + x + "," + y + ")";
            if (shortestPath.length() == 0 || shortestPath.length() > shortestPath.length())
                shortestPath = path;
            System.out.println("找到路线:" + path);
            return;
        }

        String temp = path;
        path = path + "(" + x + "," + y + ")" + "-"; // 记录路线
        maze[x][y] = 1; // 将走过的路标记
        // 向四个方向搜索
        dfsMaze(x + 1, y, maze);  //向右搜索
        dfsMaze(x, y + 1, maze);  //向下搜索
        dfsMaze(x, y - 1, maze);  //向上搜索
        dfsMaze(x - 1, y, maze);  //向左搜索
        // 将路线和标记恢复成上一次的状态
        maze[x][y] = 0;
        //清除
        path = temp;
    }

    public static void main(String[] args) {
        // 初始化一个迷宫地图
        // 0: 表示通路
        // 1:表示死路
        int[][] maze = {
                {0, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0}
        };

        int[][] maze2 = {
                {0, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0}
        };
        /*
         * 从矩阵的左上角位置开始搜索
         * */
        dfsMaze(0, 0, maze2);
        if (shortestPath.length() != 0)
            System.out.println("最短路线为：" + shortestPath);
        else
            System.out.println("没有找到路线！");


    }

}
