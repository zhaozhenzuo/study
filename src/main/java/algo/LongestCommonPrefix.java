package algo;

public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		LongestCommonPrefix longestCommonPrefix=new LongestCommonPrefix();
		
		String[] strs={"ab","abde","abc"};
		
		String res=longestCommonPrefix.longestCommonPrefix(strs);
		System.out.println(res);
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length <= 0) {
			return "";
		}

		if (strs.length == 1) {
			return strs[0];
		}

		int minLength = this.getMinLength(strs);

		/**
		 * abcd,ab,dce
		 */
		int cnt = 0;
		StringBuilder buffer = new StringBuilder(minLength);
		while (true) {
			if (cnt >= minLength) {
				break;
			}

			char c = strs[0].charAt(cnt);
			boolean flag = true;
			for (int i = 1; i < strs.length; i++) {
				if (c != strs[i].charAt(cnt)) {
					flag = false;
					break;
				}
			}

			if (!flag) {
				break;
			} else {
				buffer.append(c);
				cnt++;
			}

		}
		
		return buffer.toString();

	}

	private int getMinLength(String[] strs) {
		Integer minLength = null;
		for (String s : strs) {
			if (minLength == null) {
				minLength = s.length();
			} else {
				if (s.length() < minLength) {
					minLength = s.length();
				}
			}
		}

		return minLength;
	}

}
