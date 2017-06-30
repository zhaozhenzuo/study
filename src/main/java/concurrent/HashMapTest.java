package concurrent;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	private static Map<Integer, String> map = new HashMap<Integer, String>(2, 1);

	public static void main(String[] args) {

		map.put(3, "a");
		map.put(7, "b");
		map.put(5, "b");
	
		
//		System.out.println("==");
//
//		new Thread("thread1") {
//			public void run() {
//				System.out.println("t1 begin");
//				map.put(11, "8");
//				System.out.println("t1 end,"+map);
//			}
//		}.start();
//
//		new Thread("thread2") {
//			public void run() {
//				System.out.println("t2 begin");
//				map.put(15, "9");
//				System.out.println("t2 end,"+map);
//			}
//		}.start();

	}

}
