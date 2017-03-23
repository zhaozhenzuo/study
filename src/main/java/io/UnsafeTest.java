package io;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;

import sun.misc.Unsafe;

public class UnsafeTest {

	private long value=0;
	
	private static final long valueOffset;
	
	static final Unsafe unsafe;
	
	public UnsafeTest(int value){
		this.value=value;
	}

	static {
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe"); // Internal
			f.setAccessible(true);
			unsafe = (Unsafe) f.get(null);
			valueOffset = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("value"));
			System.out.println(valueOffset);
			
			
		} catch (Exception e){
			throw new Error(e);
		}
	}
	
	public boolean compareAndSet(long expect,long update){
		return unsafe.compareAndSwapLong(this, valueOffset, expect, update);
	}
	
	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		UnsafeTest obj=new UnsafeTest(0);
		
		boolean updateFlag=obj.compareAndSet(0, 1);
		System.out.println(updateFlag);
		System.out.println("after value:"+obj.value);
		
	}

}
