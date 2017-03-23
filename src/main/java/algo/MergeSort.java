package algo;

/**
 * 归并排序核心思想：<br/>
 * 将要排序的数组每次分分成一半，分别对其进行排序，之后做合并<br/>
 * 关键点在于合并时，需要引入一个辅助数组，用保存无序要进行合并的元素
 * 
 * @author zhaozhenzuo
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] src = { 3,2,1,6,1,13,54,1,15,34 };

		sortEntranceByAsc(src);

		for (int i : src) {
			System.out.println(i);
		}
	}

	/**
	 * 从小到大排序
	 * 
	 * @param src
	 */
	public static void sortEntranceByAsc(int[] src) {
		if (src == null || src.length <= 1) {
			return;
		}

		int n = src.length;
		int[] aux = new int[src.length];
		sort(src, aux, 0, n - 1);
	}

	/**
	 * test<br/>
	 * 3,1,5,6
	 * 
	 * @param src
	 * @param aux
	 * @param s
	 * @param e
	 */
	private static void sort(int[] src, int[] aux, int s, int e) {
		if (s >= e) {
			/**
			 * 只有一个数了，就不排了
			 */
			return;
		}

		int mid = s + (e - s) / 2;
		sort(src, aux, s, mid);
		sort(src, aux, mid + 1, e);

		if (src[mid] <= src[mid + 1]) {
			/**
			 * 优化点,这里左边集合最大的数已经小于等于右边集合了就不需要再排了
			 */
			return;
		}
		merge(src, aux, s, mid, e);
	}

	private static void merge(int[] src, int[] aux, int s, int mid, int e) {
		for (int i = s; i <= e; i++) {
			aux[i] = src[i];
		}

		/**
		 * 开始比较合并
		 */
		int index = s;
		int i = s;
		int j = mid + 1;
		while (i <= mid) {
			if (j > e) {
				break;
			}

			if (aux[i] <= aux[j]) {
				src[index++] = aux[i++];
			} else {
				src[index++] = aux[j++];
			}
		}

		/**
		 * i还剩元素
		 */
		while (i <= mid) {
			src[index++] = aux[i++];
		}

		/**
		 * j集合还乘数据的话，直接放入
		 */
		while (j <= e) {
			src[index++] = aux[j++];
		}

	}

}
