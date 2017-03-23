package algo;

public class InsertSort {

	public static void main(String[] args) {
		int[] src={3,5,1,8,3,1,1,5,5,8};
		
		sort(src);
		
		for(int i:src){
			System.out.println(i);
		}
	}

	/**
	 * 3,1,4
	 * 
	 * @param src
	 * @return
	 */
	public static int[] sort(int[] src) {
		if (src == null || src.length <= 1) {
			return src;
		}

		int n = src.length;
		for (int i = 1; i < n; i++) {
			int temp = src[i];
			
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (temp < src[j]) {
					/**
					 * 将j元素往后移一位
					 */
					src[j+1]=src[j];
				}else{
					break;
				}
			}
			
			/**
			 * 比较完后，将要比较的元素值放在j+1位置<br/>
			 * 原因：每次比较j位置元素，只有当当前要比较元素与j位置元素不需要交换位置时break
			 */
			src[j+1]=temp;
		}
		
		return src;

	}
}
