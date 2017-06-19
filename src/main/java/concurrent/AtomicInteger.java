package concurrent;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import sun.misc.Unsafe;

public class AtomicInteger {

	private volatile int value;

	private long offset;

	private Unsafe unsafe;

	public Unsafe getUnsafe()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field f = Unsafe.class.getDeclaredField("theUnsafe"); // Internal
		f.setAccessible(true);
		unsafe = (Unsafe) f.get(null);
		return unsafe;
	}

	public AtomicInteger()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		value = 0;
		unsafe = this.getUnsafe();

		offset = unsafe.objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));
	}

	public int increaseAndGet() {
		int before = value;
		while (!unsafe.compareAndSwapInt(this, offset, before, before + 1)) {
			before = value;
		}

		return value;
	}

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException, InterruptedException {
		final AtomicInteger atomicInteger = new AtomicInteger();

		int threadNums=1000;
		
		final CountDownLatch countDownLatch = new CountDownLatch(threadNums);

		ExecutorService executorService = Executors.newFixedThreadPool(threadNums);

		long oldTime = System.currentTimeMillis();
		for (int i = 0; i < threadNums; i++) {
			executorService.submit(new Runnable() {
				public void run() {
					for (int i = 0; i < 100000; i++) {
						atomicInteger.increaseAndGet();
					}
					countDownLatch.countDown();
				}
			});
		}

		countDownLatch.await();

		long cost = System.currentTimeMillis() - oldTime;
		System.out.println("cost[" + cost + "]," + countDownLatch.getCount() + ",res[" + atomicInteger.value + "]");
	}

}
