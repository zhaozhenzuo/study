package algo;

import java.util.Arrays;

public class ThreeSumCloset {

	public static void main(String[] args) {

		ThreeSumCloset obj = new ThreeSumCloset();

		int[] nums = { -3, -2, -5, 3, -4 };
		int target = -1;

		int res = obj.threeSumClosest(nums, target);
		System.out.println(res);

	}

	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}

		if (nums.length < 3) {
			return nums[0];
		}

		Arrays.sort(nums);

		int result = nums[0]+nums[1]+nums[nums.length-1];

		int length = nums.length;

		/**
		 * -3,0,1,2<br/>
		 * target = 1
		 */
		for (int i = 0; i < length - 2; i++) {
			int j = i + 1;
			int k = length - 1;
			while (true) {
				if (j >= k) {
					break;
				}

				int sum = nums[i] + nums[j] + nums[k];

				if (sum > target) {
					/**
					 * 和大于target，则向左移动右边指针<br/>
					 * 目的是找到一个更小的数，使下次相加时能够缩小与target的差距。<br/>
					 */

					k--;
				} else if (sum == target) {
					result = sum;
					break;
				} else {
					j++;
				}

				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}

			}

		}

		return result;

	}

}
