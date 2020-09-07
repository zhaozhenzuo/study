package algo;

public class DYNum200 {

    public static void main(String[] args) {
        DYNum200 dyNum200 = new DYNum200();
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}
                , {'0', '0', '0', '1', '1'}};
        int r = dyNum200.numIslands(grid);
        System.out.println(r);
    }

    private static final char dy = '1';

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length <= 0) {
            return 0;
        }

        Node[][] nodes = new Node[grid.length][grid[0].length];

        //初始化为1的并查集
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == dy && nodes[i][j] == null) {
                    //代表指向自已
                    nodes[i][j]=new Node(i,j);
                    dfs(nodes[i][j], i, j, nodes, grid, true);
                    count++;
                } else {
                    nodes[i][j] = new Node(-1,-1);
                }
            }
        }

//        //开始循环，查找出指向是自已的结点
//        int count = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                Node curNode = nodes[i][j];
//                if (curNode != null && curNode.i == i && curNode.j == j) {
//                    //根结点
//                    count++;
//                    //dfs深度优先遍历将相应的身边结点指向这个root
//                    dfs(curNode, i, j, nodes, grid, true);
//                }
//            }
//        }
        return count;
    }

    private void dfs(Node root, int i, int j, Node[][] nodes, char[][] grid, boolean first) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || (!first && root.equals(nodes[i][j]))) {
            return;
        }
        if(grid[i][j] != dy){
            return;
        }
        nodes[i][j] = root;

        //左
        dfs(root, i, j - 1, nodes, grid, false);

        //右
        dfs(root, i, j + 1, nodes, grid, false);

        //上
        dfs(root, i - 1, j, nodes, grid, false);

        //下
        dfs(root, i + 1, j, nodes, grid, false);
    }

    class Node {

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        private int i;

        private int j;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }

        public boolean equals(Node node) {
            if (node == null) {
                return false;
            }
            return node.i == i && node.j == j;
        }

    }

}
