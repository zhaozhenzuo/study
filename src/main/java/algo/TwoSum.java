package algo;

public class TwoSum {

	public static void main(String[] args) {
		TwoSum sum = new TwoSum();

		int[] nums = { 2, 7, 11, 15 };
		int target = 9;

		int[] res = sum.twoSum(nums, target);
		System.out.println(res[0] + "," + res[1]);
	}

	public int[] twoSum(int[] nums, int target) {

		if (nums == null) {
			return null;
		}

		int[] res = new int[2];

		for (int i = 0; i < nums.length; i++) {
			// if (nums[i] > target) {
			// continue;
			// }

			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					res[0] = nums[i];
					res[1] = nums[j];
					break;
				}
			}
		}

		return res;

	}

}
