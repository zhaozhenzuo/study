package concurrent;

public class A {

	private String value;

	Integer[] ints;

	private final int v;

	private static final int normalizeCapacity(int capacity) {
		// Normalize to multiple of 1024
		int q = capacity >>> 10;
		int r = capacity & 1023;
		if (r != 0) {
			q++;
		}
		return q << 10;
	}

	public static void main(String[] args) {	
		System.out.println(normalizeCapacity(65535));
	}

	public A(int v) {
		//// ints=new Integer[10];
		// Integer i1=new Integer(100228);
		// ints[0]=i1;
		this.v = v;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
