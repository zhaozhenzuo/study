package io;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import sun.misc.Unsafe;

public class DirectMemTest {

	private static long ADRESS_FIELD_OFFSET;

	private static Unsafe unsafe = getUnsafe();

	static {
		Field addressField;
		try {
			addressField = Buffer.class.getDeclaredField("address");
			ADRESS_FIELD_OFFSET = unsafe.objectFieldOffset(addressField);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

	}

	public static long getBaseAddress(Buffer buffer) {
		return unsafe.getLong(buffer, ADRESS_FIELD_OFFSET);
	}

	public static void main(String[] args) {

		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
		
		List<ByteBuffer> resList=new ArrayList<ByteBuffer>();
		
		List<Byte[]> byteList=new ArrayList<Byte[]>();
		
		while(true){
			System.out.println();
			ByteBuffer temp = ByteBuffer.allocateDirect(1024*1024*30);
			resList.add(temp);
			
//			byteList.add(new Byte[1024*104*8]);
		}

//		byte[] array = "abc".getBytes();
//
//		byteBuffer.put(array);
//
//		byteBuffer.flip();
//
//		byte[] dst = new byte[array.length];
//
//		byteBuffer.get(dst);
//
//		System.out.println(new String(dst));
//		
//		long baseOffset=getBaseAddress(byteBuffer);
//		
//		System.out.println(baseOffset);

	}

	private static Unsafe getUnsafe() {
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe"); // Internal
			f.setAccessible(true);
			Unsafe unsafe = (Unsafe) f.get(null);
			return unsafe;
		} catch (Exception e) {

		}

		return null;
	}

}
