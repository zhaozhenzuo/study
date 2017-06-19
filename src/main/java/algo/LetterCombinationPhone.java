package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhone {
	private static final Map<Integer, String[]> mapping = new HashMap<Integer, String[]>(10);

	static {
		mapping.put(0, null);
		mapping.put(1, null);

		String[] s2 = { "a", "b", "c" };
		mapping.put(2, s2);

		String[] s3 = { "d", "e", "f" };
		mapping.put(3, s3);

		String[] s4 = { "g", "h", "i" };
		mapping.put(4, s4);

		String[] s5 = { "j", "k", "l" };
		mapping.put(5, s5);

		String[] s6 = { "m", "n", "o" };
		mapping.put(6, s6);

		String[] s7 = { "p", "q", "r", "s" };
		mapping.put(7, s7);

		String[] s8 = { "t", "u", "v" };
		mapping.put(8, s8);

		String[] s9 = { "w", "x", "y", "z" };
		mapping.put(9, s9);

	}

	public static void main(String[] args) {

		LetterCombinationPhone obj = new LetterCombinationPhone();

		List<String> resList = obj.letterCombinations("22");
		System.out.println(resList.toString());

	}

	public List<String> letterCombinations(String digits) {
		if (digits == null || digits == "") {
			return new ArrayList<String>();
		}

		List<Integer> paramList = new ArrayList<Integer>(digits.length());

		for (int i = 0; i < digits.length(); i++) {
			paramList.add(Integer.valueOf(digits.substring(i, i + 1)));
		}

		if (paramList.size() <= 0) {
			return new ArrayList<String>();
		}

		if (paramList.size() == 1) {
			return Arrays.asList(mapping.get(paramList.get(0)));
		}

		List<String> resList = new ArrayList<String>(paramList.size() ^ 3);

		// init
		int[] indexArr = new int[paramList.size()];

		Map<Integer, String[]> indexValueMap = new HashMap<Integer, String[]>(indexArr.length);

		for (int i = 0; i < indexArr.length; i++) {
			indexArr[i] = 0;

			indexValueMap.put(i, mapping.get(paramList.get(i)));
		}

		while (true) {

			if (canBreak(indexArr, indexValueMap)) {
				break;
			}

			//
			String res = "";
			for (int k = 0; k < indexArr.length; k++) {
				String[] tempArr = indexValueMap.get(k);
				int index = indexArr[k];
				res += tempArr[index];
			}
			resList.add(res);

			// 处理指针增加
			int ele = indexArr.length - 1;
			while (true) {
				if (ele < 0) {
					break;
				}

				indexArr[ele] = indexArr[ele] + 1;

				int eleLength = indexValueMap.get(ele).length;
				if (indexArr[ele] > eleLength - 1 && ele != 0) {
					// 上个集合index需要加1，同时置当前集合下标为0
					indexArr[ele] = 0;
					ele = ele - 1;
				} else {
					// 相加后小于集合大小则break
					break;
				}

			}

		}

		return resList;

	}

	private boolean canBreak(int[] indexArr, Map<Integer, String[]> indexValueMap) {
		boolean breakFlag = false;

		int point = indexArr[0];
		int maxLength = indexValueMap.get(0).length;
		if (point > maxLength - 1) {
			breakFlag = true;
		}

		return breakFlag;

	}

}
