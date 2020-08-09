package concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadPoolExecutorWithThrowException extends ThreadPoolExecutor{
	
	private static Logger logger=LoggerFactory.getLogger(ThreadPoolExecutorWithThrowException.class);

	public ThreadPoolExecutorWithThrowException(int corePoolSize, int maximumPoolSize, long keepAliveTime,
			TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}
	
	@SuppressWarnings("static-access")
	protected void afterExecute(Runnable r, Throwable t){
		super.afterExecute(r, t);
		
		this.printException(r, t);
	}
	
	private static void printException(Runnable r, Throwable t) {
	    if (t == null && r instanceof Future<?>) {
	        try {
	            Future<?> future = (Future<?>) r;
	            if (future.isDone())
	                future.get();
	        } catch (CancellationException ce) {
	            t = ce;
	        } catch (ExecutionException ee) {
	            t = ee.getCause();
	        } catch (InterruptedException ie) {
	            Thread.currentThread().interrupt(); // ignore/reset
	        }
	    }
	    if (t != null){
	        System.out.println(t.getMessage());
	    }
	}

}
