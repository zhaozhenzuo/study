package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidPathlessTest {

	public static void main(String[] args) {
		ValidPathlessTest obj = new ValidPathlessTest();

		String param = "([])";

		System.out.println(obj.isValid(param));
	}

	private static final List<Character> charList = new ArrayList<Character>();

	private static final Map<Character, Character> map = new HashMap<Character, Character>();

	static {
		charList.add('(');
		charList.add(')');
		charList.add('{');
		charList.add('}');
		charList.add('[');
		charList.add(']');

		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
	}

	/**
	 * ()[]
	 * 
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
		if (s == null || s.length() <= 0 || (s.length() % 2 != 0)) {
			return false;
		}

		char[] tempArr = s.toCharArray();
		boolean valid = true;
		int n = tempArr.length;
		for (int i = 0; i < tempArr.length / 2; i++) {

			char targetLast = tempArr[n - 1 - i];
			Character tempRes = map.get(tempArr[i]);
			if (tempRes == null || tempRes != targetLast) {
				valid = false;
				break;
			}

		}

		return valid;
	}

}
