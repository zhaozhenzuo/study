package algo;

public class PlindromTest {
	
	public static void main(String[] args) {
		PlindromTest obj=new PlindromTest();
		boolean res=obj.isPalindrome(-121);
		System.out.println(res);
	}

	public boolean isPalindrome(int x) {

		// 去除符号位
		String s;
		if (x < 0) {
			return false;
		} else {
			s = String.valueOf(x);
		}

		if (s.length() <= 1) {
			return true;
		}

		// 开始判断
		int i = 0;
		int j = s.length() - 1;

		char[] charArr = s.toCharArray();

		boolean flag = true;
		while (true) {
			if (i >= j) {
				break;
			}

			if (charArr[i] != charArr[j]) {
				flag = false;
				break;
			}
			
			i++;
			j--;

		}

		return flag;
	}

}
