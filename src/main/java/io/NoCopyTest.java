package io;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;

public class NoCopyTest {
	
	public static void main(String[] args) {
//		servletOutputStream = response.getOutputStream();
//		FileChannel channel = new FileInputStream("").getChannel();
//		response.setHeader("Content-Length", String.valueOf(channel == null ? 0 : channel.size()));
//		channel.transferTo(0, channel.size(), Channels.newChannel(servletOutputStream));
		
		ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
		byteBuffer.put("hello".getBytes());
		
		ByteBuffer readBuffer=byteBuffer.slice();
		int i=0;
		while(i<readBuffer.limit()){
			System.out.println(readBuffer.getChar());
		}
		
	}

}
