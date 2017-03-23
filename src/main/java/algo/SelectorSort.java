package algo;

public class SelectorSort {

	public static void main(String[] args) {
		int[] src = { 3, 1, 4, 5, 2 };
		int[] res = sort(src);
		for (int i : res) {
			System.out.println(i);
		}
	}

	public static int[] sort(int[] src) {
		if (src == null || src.length <= 1) {
			return src;
		}

		int n = src.length;
		int minIndex;
		for (int i = 0; i < n - 1; i++) {

			minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (src[j] < src[minIndex]) {
					minIndex = j;
				}
			}

			int temp = src[minIndex];
			src[minIndex] = src[i];
			src[i] = temp;
		}

		return src;
	}

}
