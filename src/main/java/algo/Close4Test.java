package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 4 closet 4<br/>
 * leetCode
 * 
 * @author zhaozhenzuo
 *
 */
public class Close4Test {

	public static void main(String[] args) {
		Close4Test obj = new Close4Test();

		// [-1,0,1,2,-1,-4]
		// -1

		// [-3,-2,-1,0,0,1,2,3]
		// 0

		// -4,-1,-1,0,1,2
		int[] nums = { -3, -2, -1, 0, 0, 1, 2, 3 };
		int target = 0;
		List<List<Integer>> resList = obj.fourSum(nums, target);
		for (List<Integer> tempList : resList) {
			System.out.println(tempList);
		}

	}

	/**
	 * 解决一个集合中找出4个序列等于目标值target
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		if (nums == null || nums.length < 4) {
			return new ArrayList<List<Integer>>();
		}

		int n = nums.length;

		List<List<Integer>> resList = new ArrayList<List<Integer>>();

		List<Integer> numsList = new ArrayList<Integer>(nums.length);
		for (int temp : nums) {
			numsList.add(temp);
		}

		Collections.sort(numsList);

		Map<String, List<List<Integer>>> mapList = new HashMap<String, List<List<Integer>>>(nums.length / 2);

		/**
		 * -2,-1,3,5,7<br/>
		 * target=5<br/>
		 * 
		 * -2,-1,3,3,5,7
		 */
		for (int i = 0; i <= n - 4; i++) {

			for (int j = i + 1; j <= n - 3; j++) {

				if (numsList.get(i) + numsList.get(j) + numsList.get(n - 1) + numsList.get(n - 2) < target) {
					/**
					 * 最大的两位数相加前面两位数，还是小于target说明不够大
					 */
					continue;
				}

				if (numsList.get(i) + numsList.get(j) + numsList.get(j + 1) + numsList.get(j + 2) > target) {
					continue;
				}

				int low = j + 1;
				int high = n - 1;

				while (low < high) {

					int addRes = numsList.get(i) + numsList.get(j) + numsList.get(low) + numsList.get(high);
					if (addRes == target) {
						List<Integer> tempList = Arrays.asList(numsList.get(i), numsList.get(j), numsList.get(low),
								numsList.get(high));

						if (!this.isExists(tempList, mapList)) {
							resList.add(tempList);
						}

						String firstKey = numsList.get(i).toString();
						List<List<Integer>> mapStoreListByKey = mapList.get(firstKey);
						if (mapStoreListByKey == null) {
							mapStoreListByKey = new ArrayList<List<Integer>>();
							mapList.put(firstKey, mapStoreListByKey);
						}
						mapStoreListByKey.add(tempList);

						/**
						 * 过滤掉之后重复的数字，low后面有可能重复，high前面也有可能重复
						 */
						while (low < high) {
							if (numsList.get(low) == numsList.get(low + 1)) {
								low++;
							} else {
								break;
							}
						}

						while (low < high) {
							if (numsList.get(high) == numsList.get(high - 1)) {
								high--;
							} else {
								break;
							}
						}

						low++;
						high--;

					} else if (addRes > target) {
						high--;
					} else {
						low++;
					}

				}

			}

		}

		return resList;

	}

	private boolean isExists(List<Integer> tempList, Map<String, List<List<Integer>>> mapList) {
		if (mapList == null || mapList.size() <= 0) {
			return false;
		}

		if (tempList == null || tempList.size() <= 0) {
			return false;
		}

		String firstKey = tempList.get(0).toString();
		List<List<Integer>> oldDataList = mapList.get(firstKey);
		if (oldDataList == null || oldDataList.size() <= 0) {
			return false;
		}

		boolean hasFlag = false;
		for (List<Integer> oldList : oldDataList) {
			hasFlag = oldList.equals(tempList);
			if (hasFlag) {
				break;
			}
		}

		return hasFlag;
	}

}
