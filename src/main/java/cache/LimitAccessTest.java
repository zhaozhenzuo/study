package cache;

import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.RateLimiter;

public class LimitAccessTest {

	public static void main(String[] args) {
		RateLimiter limiter = RateLimiter.create(5);

		System.out.println(limiter.acquire(5));

		System.out.println(limiter.tryAcquire(1, 1000, TimeUnit.MILLISECONDS));

	}

}
