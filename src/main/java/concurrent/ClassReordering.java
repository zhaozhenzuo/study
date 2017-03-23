package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ClassReordering {

	int x = 0, y = 0;

	public void writer() {

		x = 1;

		y = 2;

	}

	public void reader() {

		int r1 = y;

		int r2 = x;
		System.out.println("r1:"+r1);
		System.out.println("r2:"+r2);

	}

	public static void main(String[] args) {
		final ClassReordering classReordering = new ClassReordering();

		final CountDownLatch countDownLatch = new CountDownLatch(1);

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		// write
		executorService.submit(new Runnable() {
			public void run() {
				try {
					countDownLatch.await();
					classReordering.writer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// read
		executorService.submit(new Runnable() {
			public void run() {
				try {
					countDownLatch.await();
					classReordering.writer();
					classReordering.reader();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		//begin
		countDownLatch.countDown();

	}

}
