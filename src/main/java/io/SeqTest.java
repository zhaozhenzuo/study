package io;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.lmax.disruptor.Sequence;

public class SeqTest {

	// 2147483646
	static final AtomicInteger seq = new AtomicInteger(0);

	static final Lock lockWhenLessThanZero = new ReentrantLock();

	static final Sequence sequence = new Sequence();
	
	static Map<Long, Integer> seqMap=new HashMap<Long, Integer>();

	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		int size = 2000;

		final ExecutorService executorService = Executors.newFixedThreadPool(size);

		final CountDownLatch countDownLatch = new CountDownLatch(1);

		final CountDownLatch countDownLatchEnd = new CountDownLatch(size);

		long oldTime = System.currentTimeMillis();

		for (int j = 0; j < 50; j++) {
			for (int i = 0; i < size; i++) {
				executorService.submit(new Runnable() {
					public void run() {
						try {
							countDownLatch.await();
							// System.out.println(getSeq());
							getSeq();
//							sequence.incrementAndGet();
						} catch (InterruptedException e) {
							e.printStackTrace();
						} finally {
							countDownLatchEnd.countDown();
						}
					}
				});

			}

			// consume
			countDownLatch.countDown();
			try {
				countDownLatchEnd.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

//			long cost = System.currentTimeMillis() - oldTime;
//			System.out.println("==cost:" + cost);
		}
		
		long cost = System.currentTimeMillis() - oldTime;
		System.out.println("==cost:" + cost);

	}

	public static int getSeq() {
		int resSeq = seq.incrementAndGet();
		if (resSeq < 0) {
			resSeq = setToZeroAndGet();
		}
		return resSeq;
	}
	

	private static int setToZeroAndGet() {
		try {
			lockWhenLessThanZero.lock();
			if (seq.get() < 0) {
				seq.set(0);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			lockWhenLessThanZero.unlock();
		}
		return seq.incrementAndGet();
	}

}
