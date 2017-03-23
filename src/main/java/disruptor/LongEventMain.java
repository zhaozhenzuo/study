package disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

public class LongEventMain {
	static Executor executor = Executors.newCachedThreadPool();
	// The factory for the event
	static LongEventFactory factory = new LongEventFactory();
	// Specify the size of the ring buffer, must be power of 2.
	static int bufferSize = 2;
	// Construct the Disruptor
	static Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory, bufferSize, executor);

	static RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

	static {
		// Connect the handler
		disruptor.handleEventsWith(new LongEventHandler());

		// Start the Disruptor, starts all threads running
		disruptor.start();
	}

	public static void main(String[] args) throws InterruptedException {
		int mark = 1023;
		int index = 1024;

		int prodNums = 5;
		ExecutorService executorService = Executors.newFixedThreadPool(prodNums);

		for (int i = 0; i < prodNums; i++) {
			executorService.submit(new Runnable() {
				public void run() {
					try {
						test();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}

//		test();
	}

	private static void test() throws InterruptedException {
		LongEventProducer producer = new LongEventProducer(ringBuffer);
		ByteBuffer bb = ByteBuffer.allocate(8);
		bb.putLong(0, 10);
		producer.onData(bb);
	}
}
