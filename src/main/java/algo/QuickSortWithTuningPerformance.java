package algo;

public class QuickSortWithTuningPerformance {

	public static void main(String[] args) {
		int[] src = { 3, 1, 2, 1, 6, 1, 1, 2, 0, 218, 10, 5, 1, 2, 1, 343, 43 };
		
		
		
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
	 * 3,1,8,5
	 * 
	 * @param src
	 * @param l
	 * @param h
	 */
	private static void sort(int[] src, int l, int h) {
		if (l >= h) {
			return;
		}

		if (h - l + 1 >= 3) {
			// 小数组用插入排序
			insertSort(src, l, h);
			return;
		}

		int j = partion(src, l, h);

		sort(src, l, j - 1);
		sort(src, j + 1, h);
	}

	/**
	 * 3,1,2
	 * 
	 * @param src
	 * @param l
	 * @param h
	 */
	private static void insertSort(int[] src, int l, int h) {
		if (src == null || src.length <= 1) {
			return;
		}

		for (int i = l + 1; i <= h; i++) {
			int temp = src[i];
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (temp < src[j]) {
					src[j + 1] = src[j];
				} else {
					break;
				}
			}
			src[j + 1] = temp;
		}

	}

	private static int partion(int[] src, int l, int h) {
		int partionIndex = obtainPartionIndex(src, l, h);

		int i = l;// 设置i为l，后续处理是从i+1开始，这里原因是三分中值后，i元素肯定<=mid
		int j = h; // 三分中值后，h位置元素肯定>=mid大
		int partionValue = src[partionIndex];
		while (true) {

			while (true) {
				if (src[++i] >= partionValue) {
					break;
				}
			}

			while (true) {
				if (src[--j] <= partionValue) {
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

	/**
	 * 改进成三分中值<br/>
	 * 3,1,5
	 * 
	 * @param src
	 * @param l
	 * @param h
	 * @return
	 */
	private static int obtainPartionIndex(int[] src, int l, int h) {
		int mid = l + (h - l) / 2;

		if (src[l] > src[mid]) {
			replace(src, l, mid);
		}

		if (src[l] > src[h]) {
			replace(src, l, h);
		}

		if (src[mid] > src[h]) {
			replace(src, mid, h);
		}

		return mid;
	}

}
