package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadState {
	
	public static void main(String[] args) {
		
		Thread t1=new Thread(new SyncTask());
		t1.setName("thread1");
		t1.start();
		
		Thread t2=new Thread(new SyncTask());
		t2.setName("thread2");
		t2.start();
		
	}
	
	static class SyncTask implements Runnable{
		
		static Lock lock=new ReentrantLock();

		public void run() {
			
				try {
					//lock.lock();
					
					synchronized (lock) {
						System.out.println("enter,thread id["+Thread.currentThread()+"]");
						//Thread.sleep(200000L);
						if(Thread.currentThread().getName().equals("thread1")){
							lock.wait();
						}else{
							lock.notifyAll();
						}
						
						System.out.println("wake up,thread id["+Thread.currentThread()+"]");
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					//lock.unlock();
				}
			
		}
		
		
	}

}
