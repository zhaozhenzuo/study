package algo;

public class Friend547 {

    public int findCircleNum(int[][] m) {
        if(m == null || m.length<=0 || m.length!=m[0].length){
            return 0;
        }

        UF uf=new UF();
        uf.init(m.length);
        for(int i=0;i<m.length;i++){
            for(int j=0;j<i;j++){
                if(m[i][j] == 1){
                    uf.union(i,j);
                }
            }
        }
        return uf.count;
    }


    class UF {
        /**
         * 父结点
         */
        private int[] parent;

        /**
         * 权重
         */
        private int[] size;

        /**
         * 连通个数
         */
        private int count;

        public void init(int n) {
            if (n <= 0) {
                return;
            }
            parent=new int[n];
            size=new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            count=n;
        }

        public int find(int x) {
            int cur = x;
            while (parent[cur] != cur) {
                cur = parent[cur];
            }
            return cur;
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if(xRoot == yRoot){
                return;
            }

            if (size[xRoot] > size[yRoot]) {
                parent[yRoot] = xRoot;
                size[xRoot] += size[yRoot];
            } else {
                parent[xRoot] = yRoot;
                size[yRoot] += size[xRoot];
            }
            count--;
        }

        public boolean connect(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            return xRoot == yRoot;
        }

        public int[] getParent() {
            return parent;
        }

        public void setParent(int[] parent) {
            this.parent = parent;
        }

        public int[] getSize() {
            return size;
        }

        public void setSize(int[] size) {
            this.size = size;
        }
    }

}
