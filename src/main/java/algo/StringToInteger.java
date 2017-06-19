package algo;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class StringToInteger {

	public static void main(String[] args) {
		StringToInteger obj = new StringToInteger();

		int rs = obj.myAtoi("1a");
		System.out.println(rs);
	}

	public int myAtoi(String str) {

		if (str == null || str == "") {
			return 0;
		}

		Set<String> legalSet = new HashSet<String>();
		legalSet.add("0");
		legalSet.add("1");
		legalSet.add("2");
		legalSet.add("3");
		legalSet.add("4");
		legalSet.add("5");
		legalSet.add("6");
		legalSet.add("7");
		legalSet.add("8");
		legalSet.add("9");

		String temp = str.trim();
		if (temp == null || "".equals(temp)) {
			return 0;
		}

		String plus = "+";
		String minus = "-";

		String first = temp.substring(0, 1);
		if (!plus.equals(first) && !minus.equals(first) && !this.isValid(first, legalSet)) {
			return 0;
		}

		boolean startFlag = false;
		
		StringBuilder buffer = new StringBuilder();
		if (plus.equals(first)) {
			// 正号不需要加
		} else if (minus.equals(first)) {
			// 负号
			buffer.append(first);
		} else {
			/**
			 * 数字
			 */
			if (!"0".equals(first)) {
				buffer.append(first);
				startFlag=true;
			}
		}

		char[] charArr = temp.toCharArray();

		/**
		 * +1.5<br/>
		 * -138
		 */
		for (int i = 1; i < temp.length(); i++) {
			char c = charArr[i];
			String cs = String.valueOf(c);

			if (!this.isValid(cs, legalSet) && !startFlag) {
				// 出现非法字符
				return 0;
			}

			if (!this.isValid(cs, legalSet) && startFlag) {
				break;
			}

			if (Integer.valueOf(cs).intValue() > 0) {
				startFlag = true;
			}

			if (startFlag) {
				buffer.append(cs);
			}

		}

		try {
			BigDecimal resBig=new BigDecimal(buffer.toString());
			if (resBig.doubleValue() < -2147483648) {
				return -2147483648;
			} else if (resBig.doubleValue() > 2147483647) {
				return 2147483647;
			} else {
				return resBig.intValue();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}

	}

	public boolean isValid(String c, Set<String> legalSet) {
		return legalSet.contains(c);
	}

}
