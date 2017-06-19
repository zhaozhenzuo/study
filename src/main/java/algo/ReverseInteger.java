package algo;

public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger reverseInteger = new ReverseInteger();

		int res = reverseInteger.reverse(-2147483648);

		System.out.println(res);

	}

	public int reverse(int x) {
		if (x == 0) {
			return x;
		}

		String signal = null;
		String xStr;
		if (x < 0) {
			signal = "-";
			xStr = String.valueOf(x).substring(1);
		} else {
			xStr = String.valueOf(x);
		}

		if (xStr.length() <= 1) {
			return x;
		}

		char[] charArr = xStr.toCharArray();

		StringBuilder builder = new StringBuilder(charArr.length);
		if (signal != null) {
			builder.append(signal);
		}

		for (int i = xStr.length() - 1; i >= 0; i--) {
			builder.append(charArr[i]);
		}

		long resLong = Long.valueOf(builder.toString());

		int maxInt = 2147483647;
		int minInt = -2147483648;

		if (resLong > maxInt || resLong < minInt) {
			return 0;
		}

		return (int) resLong;
	}

}
