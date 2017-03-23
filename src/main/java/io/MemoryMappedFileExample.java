package io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

public class MemoryMappedFileExample {
	// static int length = 128 * 1024 * 1024; // 128 Mb

	public static void main(String[] args) throws Exception {
		testWrite();
	}

	@SuppressWarnings("resource")
	private static void testWrite() throws IOException {
		File file = new File("/Users/zhaozhenzuo/Documents/studyRecord/t.txt");
		FileChannel fileChannel = new RandomAccessFile(file, "rw").getChannel();
		
		MappedByteBuffer out = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
		Date curDate = new Date();
		long dateStr = curDate.getTime();
		String res = "hi,time:" + dateStr;
		
		out.put(res.getBytes());

		out.flip();
		byte[] bytes = new byte[out.limit()];
		out.get(bytes);
		System.out.println("res:" + new String(bytes));

	}

	private static void testRead() throws IOException {
		File file = new File("/Users/zhaozhenzuo/Documents/studyRecord/t.txt");
		FileChannel fileChannel = new RandomAccessFile(file, "rw").getChannel();
		long length = fileChannel.size();

		MappedByteBuffer out = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, length);

		for (int i = 0; i < out.limit(); i++) {
			System.out.println((char) out.get());
		}
		System.out.println("Finished writing");

	}
}
