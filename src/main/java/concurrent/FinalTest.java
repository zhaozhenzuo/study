package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FinalTest {
	
	static FinalTest finalTest;
	
	boolean flag;
	
	int data;

	final static CountDownLatch countDownLatch = new CountDownLatch(1);

	public FinalTest() {
		data=5;
		flag=true;
	}

	private static void write() {
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finalTest = new FinalTest();
	}

	private static void read() {
		try {
			countDownLatch.await();
			System.out.println("read wait up,thread:" + Thread.currentThread().getId());
			if(finalTest!=null && finalTest.flag){
				System.out.println(finalTest.data);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		// init
		executorService.submit(new Runnable() {
			public void run() {
				System.out.println("write thread:" + Thread.currentThread().getId());
				write();
			}
		});

		// read
		executorService.submit(new Runnable() {
			public void run() {
				System.out.println("read thread:" + Thread.currentThread().getId());
				read();
			}
		});

		countDownLatch.countDown();

	}

}
