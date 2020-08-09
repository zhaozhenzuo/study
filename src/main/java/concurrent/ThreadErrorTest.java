package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadErrorTest {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ThreadPoolExecutor executorService=new ThreadPoolExecutor(10, 10, 60,
				TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(10000));
		
		Future<String> res1=executorService.submit(new Callable<String>() {
			public String call() throws Exception {
				return "a";
			}
		});
		
		System.out.println("===res1["+res1.get()+"]");
		
		Future<String> res2=executorService.submit(new Callable<String>() {
			public String call() throws Exception {
//				throw new RuntimeException("b error");
				return "res2";
			}
		});
		
		System.out.println("===res2["+res2.get()+"]");
		
		Future res3=executorService.submit(new Runnable() {
			public void run() {
				System.out.println("c");
				throw new IllegalArgumentException("res3");
			}
		});
		
//		System.out.println(res3.get());
		
		System.out.println("===finish");
		
	}

}
