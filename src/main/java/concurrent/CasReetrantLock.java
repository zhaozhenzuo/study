package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CasReetrantLock implements Lock {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		lock.lock();
		try{
			//
		}finally{
			lock.unlock();
		}

	}

	private Sync sync;

	public CasReetrantLock() {
		sync = new Sync();
	}

	public void lock() {
		sync.Lock();
	}

	private static class Sync extends AbstractQueuedSynchronizer {

		public void Lock() {
			if (compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return;
			} else {
				acquire(1);
			}
		}

		@Override
		public boolean tryAcquire(int cnt) {
			int state = getState();
			Thread curThread = Thread.currentThread();

			if (state == 0) {
				if (compareAndSetState(state, 1)) {
					setExclusiveOwnerThread(curThread);
					return true;
				}
				return false;

			} else if (curThread == getExclusiveOwnerThread()) {
				/**
				 * 重入，锁计数加1
				 */
				setState(getState() + 1);
				return true;
			}

			return false;
		}

		public void unlock() {
			release(1);
		}

		@Override
		public boolean tryRelease(int arg) {
			int state = getState();

			if (state <= 0) {
				throw new IllegalArgumentException("锁状态异常，不能为0");
			}

			int res = state - 1;
			setState(res);

			return true;
		}

	}

	public void lockInterruptibly() throws InterruptedException {

	}

	public boolean tryLock() {
		return false;
	}

	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	public void unlock() {
		sync.unlock();
	}

	public Condition newCondition() {
		return null;
	}

}
