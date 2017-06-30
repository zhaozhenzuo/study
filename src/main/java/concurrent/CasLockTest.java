package concurrent;

import java.util.concurrent.locks.Lock;

public class CasLockTest {

	private static Lock lock = new CasReetrantLock();

	public static void main(String[] args) {
		
		Thread t1=new Thread(new LockTask());
		t1.start();
		
		Thread t2=new Thread(new LockTask());
		t2.start();

	}

	private static class LockTask implements Runnable {

		public void run() {
			lock.lock();
			try {	
				System.out.println("=begin,threadId[" + Thread.currentThread().getId() + "]");
				Thread.sleep(10000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}

		}

	}

}
