package concurrent;

public class JoinTest {

	public static void main(String[] args) {
		Thread t1=new Thread(new ShowTask());
	    t1.start();
	    
	    try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private static class ShowTask implements Runnable {

		public void run() {
			System.out.println("show task begin");
			try {
				Thread.currentThread().sleep(3000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
