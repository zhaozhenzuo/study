package algo;

public class LongestSubString {

	public static void main(String[] args) {
		String s = "abcdatagtaakaa";

		LongestSubString obj = new LongestSubString();

		System.out.println(obj.longestPalindrome(s));

	}

	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}

		char[] charArr = s.toCharArray();

		String res = null;
		int maxLength = -1;

		for (int i = 0; i < s.length(); i++) {
			char temp = charArr[i];

			/**
			 * 对每个位置上的char从字符串末尾开始找，找到相同字符的位置<br/>
			 * 找到后，判断这个串是不是回文串
			 */
			int lastIndex;
			int lastFromIndex = s.length() - 1;

			int remainMaxLength = lastFromIndex - i + 1;

			if (remainMaxLength <= maxLength) {
				break;
			}

			/**
			 * abbdbdb
			 */
			while (true) {
				lastIndex = s.lastIndexOf(temp, lastFromIndex);
				lastFromIndex = lastIndex - 1;

				if (lastIndex <= i) {
					break;
				} else {
					/**
					 * 找到，则从lastIndex分别一对一对比较
					 */
					int length = lastIndex - i + 1;
					if (length <= maxLength) {
						/**
						 * 当前这个位置的字符，最大长度匹配串小于等于已经存在的匹配串，则结束
						 */
						break;
					}

					if (this.isHw(charArr, i, lastIndex)) {
						res = s.substring(i, lastIndex + 1);
						maxLength = length;
						break;
					}
				}
			}

		}

		if (res == null) {
			res = s.substring(0, 1);
		}

		return res;
	}

	/**
	 * 是否是回文
	 * 
	 * @param charArr
	 * @param beforeIndex
	 *            开始字符位置
	 * @param lastIndex
	 *            最后一个字符位置
	 * @return
	 */
	private boolean isHw(char[] charArr, int beforeIndex, int lastIndex) {
		if (beforeIndex == lastIndex) {
			return true;
		}

		if (charArr[beforeIndex] != charArr[lastIndex]) {
			return false;
		}

		boolean hwFlag = true;
		int before = beforeIndex;
		int after = lastIndex;

		/**
		 * abccba
		 */
		while (true) {
			if (before < 0 || after >= charArr.length || before >= after) {
				break;
			}

			if (charArr[before] != charArr[after]) {
				hwFlag = false;
				break;
			}

			before = before + 1;
			after = after - 1;
		}

		return hwFlag;
	}

}
