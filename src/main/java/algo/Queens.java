package algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Queens {

    public static void main(String[] args) {
        Queens queens = new Queens();
        List<List<String>> rList=queens.solveNQueens(5);
        System.out.println(rList);
    }

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<List<String>> rList = new ArrayList<>();
        int firstRow = 0;
        List<String> tempList = null;
        for (int c = 0; c < n; c++) {
            //循环第一行每一列
            Set<Integer> pie = new HashSet<>(4);
            Set<Integer> na = new HashSet<>(4);
            Set<Integer> col = new HashSet<>(4);
            tempList=new ArrayList<>();
            pie.add(firstRow+c);
            na.add(c - firstRow);
            col.add(c);

            //看下后面几行是否都能放下
            tempList.add(getStringByCol(c, n));
            for (int row = 1; row < n; row++) {
                String r = getSolution(row, pie, na, col, n);
                if (r == null) {
                    break;
                }
                tempList.add(r);
            }
            if (tempList.size() == n) {
                //有结果
                rList.add(tempList);
            }
        }
        return rList;
    }

    private String getStringByCol(int col, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == col) {
                builder.append("Q");
            } else {
                builder.append(".");
            }
        }
        return builder.toString();
    }

    /**
     * 获取结果
     *
     * @param row 当前行
     * @param pie
     * @param na
     * @param col
     * @param n
     * @return 当前行放入q的结果字符串表示
     */
    private String getSolution(int row, Set<Integer> pie, Set<Integer> na, Set<Integer> col, int n) {
        for (int j = 0; j < n; j++) {
            if (col.contains(j)) {
                //放不下
                continue;
            }
            if(pie.contains(row + j)){
                continue;
            }
            if(na.contains(j - row)){
                continue;
            }
            pie.add(row+j);
            na.add(j - row);
            col.add(j);
            return getStringByCol(j, n);
        }
        return null;
    }

}
