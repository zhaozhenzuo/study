package algo;

public class Frind457Solution2 {

    public static void main(String[] args) {
        Frind457Solution2 frind457Solution2 = new Frind457Solution2();
//        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}
//                , {'0', '0', '0', '1', '1'}};

        int[][] grid=new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        int r = frind457Solution2.findCircleNum(grid);
        System.out.println(r);
    }

    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

//    private static final int HAS_RELATION_FLAG = 1;
//
//    public int findCircleNum(int[][] grid) {
//        if (grid == null || grid.length <= 0) {
//            return 0;
//        }
//
//        Node[][] nodes = new Node[grid.length][grid[0].length];
//
//        //初始化为1的并查集
//        int count = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == HAS_RELATION_FLAG && nodes[i][j] == null) {
//                    //代表指向自已
//                    nodes[i][j] = new Node(i, j);
//                    dfs(nodes[i][j], i, j, nodes, grid, true);
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    private void dfs(Node root, int i, int j, Node[][] nodes, int[][] grid, boolean first) {
//        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || (!first && root.equals(nodes[i][j]))) {
//            return;
//        }
//        if (grid[i][j] != HAS_RELATION_FLAG) {
//            return;
//        }
//        nodes[i][j] = root;
//
//        //左
//        dfs(root, i, j - 1, nodes, grid, false);
//
//        //右
//        dfs(root, i, j + 1, nodes, grid, false);
//
//        //上
//        dfs(root, i - 1, j, nodes, grid, false);
//
//        //下
//        dfs(root, i + 1, j, nodes, grid, false);
//    }
//
//    class Node {
//
//        public Node(int i, int j) {
//            this.i = i;
//            this.j = j;
//        }
//
//        private int i;
//
//        private int j;
//
//        public int getI() {
//            return i;
//        }
//
//        public void setI(int i) {
//            this.i = i;
//        }
//
//        public int getJ() {
//            return j;
//        }
//
//        public void setJ(int j) {
//            this.j = j;
//        }
//
//        public boolean equals(Node node) {
//            if (node == null) {
//                return false;
//            }
//            return node.i == i && node.j == j;
//        }
//
//    }

}
