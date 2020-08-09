package algo;

import java.util.*;

public class QueensDFS {

    public static void main(String[] args) {
        QueensDFS queensDFS=new QueensDFS();
        List<List<String>> r=queensDFS.solveNQueens(4);
        System.out.println(r);
    }

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        List<List<String>> rList = new ArrayList<>();
        List<String> tempR = new ArrayList<>(4);
        Set<Integer> pie = new HashSet<>(4);
        Set<Integer> na = new HashSet<>(4);
        Set<Integer> col = new HashSet<>(4);
        Map<Integer,String> cacheMap=new HashMap<>(4);
        for(int i=0;i<n;i++){
            cacheMap.put(i,getStringByCol(i,n));
        }

        rList = dfsSearch(0, rList, n, tempR, pie, na, col,cacheMap);
        return rList;
    }

    private List<List<String>> dfsSearch(int row, List<List<String>> rList, int n, List<String> tempR,
                                         Set<Integer> pie, Set<Integer> na, Set<Integer> col,Map<Integer,String> cacheMap) {
        if (row >= n) {
            //搜索到最后一级
            List<String> result = new ArrayList<>(tempR);
            rList.add(result);
            return rList;
        }

        //每层从第一列开始到最后一列判断是否符合条件
        for (int j = 0; j < n; j++) {
            if (!isMatchRule(row, j, pie, na, col)) {
                continue;
            }
            String s=cacheMap.get(j);
            tempR.add(s);
            pie.add(row+j);
            na.add(row-j);
            col.add(j);
            dfsSearch(row + 1, rList, n, tempR, pie, na, col,cacheMap);

            //清空
            pie.remove(row+j);
            na.remove(row-j);
            col.remove(j);
            tempR.remove(s);
        }
        return rList;
    }

    private boolean isMatchRule(int row, int j, Set<Integer> pie, Set<Integer> na, Set<Integer> col) {
        if (pie.contains(row + j) || na.contains(row - j) || col.contains(j)) {
            return false;
        }
        return true;
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
}
