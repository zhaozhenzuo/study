package concurrent;

import java.math.BigDecimal;

public class A {
	
	private String value;
	
	Integer[] ints;
	
	private final int v;
	
	
	public static void main(String[] args) {
		double amount=10000;
		BigDecimal tenThousandRate=new BigDecimal("1");
		
		BigDecimal annualRate=tenThousandRate.multiply(new BigDecimal("365")).divide(new BigDecimal("10000"));
		
//		50000×（1+3%）^30;
	}
	
	
	public A(int v){
////		ints=new Integer[10];
//		Integer i1=new Integer(100228);
//		ints[0]=i1;
		this.v=v;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
