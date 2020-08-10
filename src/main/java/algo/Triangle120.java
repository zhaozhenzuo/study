package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle120 {

    public static void main(String[] args) {
        Triangle120 triangle120 = new Triangle120();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(3, 2));
        triangle.add(Arrays.asList(-3, 1, -1));
        //[[-1],[3,2],[-3,1,-1]]

        int r = triangle120.minimumTotal(triangle);
        System.out.println(r);

//        [[2],[3,4],[6,5,7],[4,1,8,3]]

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() <= 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        int rowNum = triangle.size();
        int[][] dp = new int[rowNum][rowNum];
        Integer minRes = null;
        for (int i = 0; i < rowNum; i++) {
            List<Integer> colList = triangle.get(i);
            boolean lastRowFlag = i == (rowNum - 1);
            for (int j = 0; j < colList.size(); j++) {
                //上一层最小值
                int minValue = getUpRowMin(i, j, triangle, dp);

                //本结点最小值=上层最小值+当前数值
                dp[i][j] = minValue + triangle.get(i).get(j);
                if (lastRowFlag) {
                    //最后一行
                    if (minRes == null) {
                        minRes = dp[i][j];
                    } else {
                        if (dp[i][j] < minRes) {
                            minRes = dp[i][j];
                        }
                    }
                }
            }
        }
        return minRes;
    }

    private int getUpRowMin(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        int upRow = i - 1;
        if (upRow < 0) {
            //首行，因为没有上面的行，所以返回0
            return 0;
        }
        int upLeftIndex = j - 1;
        int upIndex = j;
        int upRowColSize = triangle.get(upRow).size();
        Integer minValue = null;
        if (upLeftIndex >= 0 && upLeftIndex < upRowColSize) {
            minValue = dp[upRow][upLeftIndex];
        }
        if (upIndex >= 0 && upIndex < upRowColSize) {
            if (minValue == null || dp[upRow][upIndex] < minValue) {
                minValue = dp[upRow][upIndex];
            }
        }
        return minValue;
    }

}
