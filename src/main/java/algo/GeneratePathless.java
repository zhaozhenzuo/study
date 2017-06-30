package algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归解决<br/>
 * 
 * @author zhaozhenzuo
 *
 */
public class GeneratePathless {

	public static void main(String[] args) {
		GeneratePathless obj = new GeneratePathless();

		int n = 3;

		List<String> resList = obj.generateParenthesis(n);
		System.out.println(resList.toString());
	}

	public List<String> generateParenthesis(int n) {
		List<String> resList = new ArrayList<String>();

		generate(resList, "", n, n);

		return resList;
	}

	private void generate(List<String> resList, String res, int l, int r) {
		if (l > r) {
			return;
		}

		if (l > 0) {
			generate(resList, res + "(", l - 1, r);
		}

		if (r > 0) {
			generate(resList, res + ")", l, r - 1);
		}

		if (l == 0 && r == 0) {
			resList.add(res);
			return;
		}

	}

}
