package io;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class UnSafeConstrucotrTest {

	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InstantiationException {
		Field f = Unsafe.class.getDeclaredField("theUnsafe"); // Internal
		f.setAccessible(true);
		Unsafe unsafe = (Unsafe) f.get(null);

		A a = new A();
		System.out.println(a.getAge());

		A a2 = (A) unsafe.allocateInstance(A.class);
		System.out.println(a2.getAge());

	}

	static class A {
		private int age;

		public A() {
			age = 10;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

	}

}
