package algo;

/**
 * 快速排序思路：<br/>
 * 找到一个枢纽元，切分成两个子数组，使左边元素小于等于枢纽元，右边子数组大于等于枢纽元<br/>
 * 然后不断递归处理左子子数组。<br/>
 * 实现中很重要一点是，用两个指针i,j。使得j+1到h的元素都大于等于枢纽元，使得到l到i-1的元素都小于等于枢纽元。<br/>
 * 
 * 
 * @author zhaozhenzuo
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] src = { 3, 12, 31, 1, 2, 1, 6, 1, 1, 2, 0, 218, 7, 2, 1, 20 };
		// int[] src = { 3, 1, 4,5 };
		sortEntrance(src);

		for (int i : src) {
			System.out.println(i);
		}
	}

	public static void sortEntrance(int[] src) {
		if (src == null || src.length <= 1) {
			return;
		}

		int l = 0;
		int h = src.length - 1;
		sort(src, l, h);
	}

	/**
	 * 3,1,8,5,2
	 * 
	 * @param src
	 * @param l
	 * @param h
	 */
	private static void sort(int[] src, int l, int h) {
		if (l >= h) {
			return;
		}

		int j = partion(src, l, h);

		sort(src, l, j - 1);
		sort(src, j + 1, h);
	}

	/**
	 * 3,1,8,5,2
	 * 
	 * @param src
	 * @param l
	 * @param h
	 * @return
	 */
	private static int partion(int[] src, int l, int h) {
		int partionIndex = obtainPartionIndex(src, l, h);

		int i = l;
		int j = h + 1;
		int partionValue = src[partionIndex];
		while (true) {

			while (true) {
				if (src[++i] >= partionValue) {
					break;
				}
				if (i == h) {
					break;
				}
			}

			while (true) {
				if (src[--j] <= partionValue) {
					break;
				}
				if (j == l) {
					break;
				}
			}

			if (i >= j) {
				break;
			}

			// 交换,i,j位置元素
			replace(src, i, j);
		}

		replace(src, partionIndex, j);

		return j;

	}

	private static void replace(int[] src, int i, int j) {
		int temp = src[i];
		src[i] = src[j];
		src[j] = temp;
	}

	private static int obtainPartionIndex(int[] src, int l, int h) {
		return l;
		// int mid = l + (h - l) / 2;
		// return mid;
	}

}
