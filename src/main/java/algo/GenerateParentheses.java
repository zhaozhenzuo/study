package algo;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses generateParentheses=new GenerateParentheses();
        List<String> r=generateParentheses.generateParenthesis(2);
        System.out.println(r);
    }

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        generateRecur(result, "", n, n);
        return result;
    }

    private void generateRecur(List<String> resultList,
                               String resultStr, int leftCnt, int rightCnt) {
        if (leftCnt == 0 && rightCnt == 0) {
            resultList.add(resultStr);
            return;
        }

        if (leftCnt > 0) {
            generateRecur(resultList, resultStr + "(", leftCnt - 1, rightCnt);
        }
        if (rightCnt > leftCnt) {
            generateRecur(resultList, resultStr + ")", leftCnt, rightCnt - 1);
        }
    }

}
