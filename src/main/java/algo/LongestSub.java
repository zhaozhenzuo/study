package algo;

import java.util.HashSet;
import java.util.Set;

public class LongestSub {

	public static void main(String[] args) {
		LongestSub longestSub = new LongestSub();

		String s = "abcbb";
		System.out.println(longestSub.lengthOfLongestSubstring(s));
	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() <= 0) {
			return 0;
		}

		if (s.length() == 1) {
			return 1;
		}

		int maxLength = 0;
		int curLength = 0;
		Set<Character> visitedSet = new HashSet<Character>();

		/**
		 * dvdf
		 */
		int n = s.length();
		for (int i = 0; i < n; i++) {
			curLength = 0;
			visitedSet.clear();

			if (maxLength >= (n - i)) {
				break;
			}

			for (int j = i; j < n; j++) {
				if (visitedSet.contains(s.charAt(j))) {
					/**
					 * 有重复，结束这个子串
					 */
					System.out.println(visitedSet.toString());
					break;
				} else {
					/**
					 * 未重复
					 */
					curLength++;
					visitedSet.add(s.charAt(j));
				}
			}

			if (curLength > maxLength) {
				maxLength = curLength;
			}
		}
		return maxLength;
	}

}
