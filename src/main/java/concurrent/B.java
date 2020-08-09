package concurrent;

public class B extends A{

	public B(int v) {
		super(v);
	}
	
	public static void main(String[] args) {
		String s="abc";
		
		System.out.println(s.equals("d"));
	}
	

}
