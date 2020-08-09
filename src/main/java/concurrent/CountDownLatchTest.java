package concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	
	public static void main(String[] args) {
		
		final CountDownLatch countDownLatch=new CountDownLatch(2);
		
		Thread t1=new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("h1");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				countDownLatch.countDown();
			}
		});
		
		t1.start();
		
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("h2");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				countDownLatch.countDown();
			}
		});
		
		t2.start();
		
		Thread t3=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("t3");
				
				try {
					countDownLatch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("t3 finish");
			}
		});
		
		t3.start();
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("finish");
	}

}
