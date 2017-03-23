package algo;

public class FabRiTest {

	public static void main(String[] args) {

		int i = 0;
		int j = 1;

		int temp;
		/**
		 * 1,1,2,3,5,8
		 */
		while (j < 10) {
			System.out.println(j);
			temp = j;
			j = i + j;
			i = temp;
			
		}

	}

}
