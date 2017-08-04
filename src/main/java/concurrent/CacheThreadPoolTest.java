package concurrent;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CacheThreadPoolTest {
	
	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
				1, 1, 1, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		
		
		threadPoolExecutor.submit(new Runnable() {
			public void run() {
				System.out.println(">hi 1 start");
				
				System.out.println(">hi 1 finish");
			}
		});
		
		threadPoolExecutor.submit(new Runnable() {
			public void run() {
				System.out.println(">hi 2 start");
				
				System.out.println(">hi 2 finish");
			}
		});
		
	}

}
