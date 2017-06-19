package algo;

public class ZigZagConvertion {

	public static void main(String[] args) {

		ZigZagConvertion zagConvertion = new ZigZagConvertion();

		String res = zagConvertion.convert("PAYPALISHIRING", 9);
		System.out.println(res);
	}

	public String convert(String s, int numRows) {
		if (s == null || s.length() <= 1 || numRows <= 1) {
			return s;
		}

		int numColumns = getColNums(numRows, s.length());

		/**
		 * 建立矩阵
		 */
		char[][] arr = new char[numRows][numColumns];

		char[] charArr = s.toCharArray();

		/**
		 * PAHNAPLSIIGYIR<br/>
		 * 
		 */
		int colNo = 0;
		int pos = 0;

		/**
		 * 1代表这列每行都有数据,0代表这列只有一个数据
		 */
		int mode = 1;

		while (true) {
			if (pos >= s.length()) {
				break;
			}

			if (mode == 1) {
				for (int i = 0; i < numRows; i++) {
					if (pos >= s.length()
							|| colNo>=numColumns) {
						break;
					}
					
					
					arr[i][colNo] = charArr[pos++];
				}

				// 切换成单列只有一个数据
				mode = 0;
				colNo++;
			} else {
				/**
				 * 单列只有一个数据
				 */
				int iterateNums = numRows - 2;
				for (int i = 0; i < iterateNums; i++) {
					if (pos >= s.length()
							|| colNo>=numColumns) {
						break;
					}

					// 确定row位置
					int rowIndex = numRows - 2 - i;
					arr[rowIndex][colNo] = charArr[pos++];
					colNo++;
				}

				mode = 1;
			}

		}

		/**
		 * 2.按列 遍历结果arr
		 */
		StringBuilder buffer = new StringBuilder(s.length());
		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numColumns; c++) {
				int temp = arr[r][c];
				if (temp != 0) {
					buffer.append((char) temp);
				}

			}

		}

		return buffer.toString();

	}

	/**
	 * 
	 * 获取列数
	 * 
	 * @param rows
	 *            行数
	 * @param length
	 *            总长度
	 * @return
	 */
	public static int getColNums(int rows, int length) {
		int colsOne=rows-2;
		
		int group=rows+colsOne;
		
		int numsPerGroup=1+colsOne;
		
		int r1=(length/group)*numsPerGroup;
		
		int r2=length%group;
		
		int remain=r2-rows;
		
		if(r2<=rows){
			r1=r1+1;
		}else{
			r1=r1+1+remain;
		}
		
		return r1;
		
		
	}

}
