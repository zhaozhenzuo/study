package algo;

public class MaxAreaTest {

	public static void main(String[] args) {
		MaxAreaTest maxAreaTest = new MaxAreaTest();

		int[] height = { 6 };

		int res=maxAreaTest.maxArea(height);
		System.out.println(res);
	}

	/**
	 * 4,8,5,7,3,9,6<br/>
	 * 4*5=20<br/>
	 * 12<br/>
	 * 4<br/>
	 * 6
	 * 
	 * @param height
	 * @return
	 */

	public int maxArea(int[] height) {
		if (height == null || height.length <= 1) {
			return 0;
		}

		int length = height.length;

		int i = 0;
		int j = length - 1;

		int res = Math.min(height[i], height[j]) * (j - i);

		/**
		 * 5,4,7,8,6
		 */
		while (true) {
			if (i >= j) {
				break;
			}

			if (height[i] < height[j]) {
				/**
				 * 从小的那边开始收缩<br/>
				 * 找到一个比当前这个高度高的
				 */
				int k = i + 1;
				while (true) {
					if (k >= j || height[k] > height[i]) {
						break;
					}
					k++;
				}

				i = k;

				int temp = Math.min(height[i], height[j]) * (j - i);
				if (temp > res) {
					res = temp;
				}
			} else {
				/**
				 * 右边的块高度小于左边的块高度，从右边开始收缩<br/>
				 * 找到一块高度大于当前块的值
				 */
				int k = j - 1;

				while (true) {
					if (k <= i || height[k] > height[j]) {
						break;
					}
					k--;
				}

				j = k;
				int temp = Math.min(height[i], height[j]) * (j - i);
				if (temp > res) {
					res = temp;
				}

			}

		}

		return res;

	}

}
