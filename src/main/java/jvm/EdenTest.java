package jvm;

import java.util.ArrayList;
import java.util.List;

public class EdenTest {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("hi");

		List<Byte[]> resList = new ArrayList<Byte[]>();

		for (int i = 0; i < 8; i++) {
			resList.add(new Byte[1024 * 1024 * 10]);
		}

		System.out.println("finish");

	}

}
