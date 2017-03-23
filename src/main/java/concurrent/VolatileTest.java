package concurrent;

public class VolatileTest {
	
	static boolean flag=true;
	
	public static void main(String[] args) {
		
		Thread thread=new Thread(new Runnable() {
			public void run() {
				try {
					System.out.println("t1-sleep-before");
					Thread.currentThread().sleep(2000L);
					System.out.println("t1-sleep-end");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				flag=false;
			}
		});
		thread.start();
		
		int count=0;
		
		while(flag){
//			System.out.println("==");
//			Map<String,String> map=new HashMap<String, String>();
//			Object object=new Object();
//			List<String> list=new ArrayList<String>();
//			list.add("a");
//			A[] arr=new A[3];
//			
//			byte[] bytes=new byte[5];
			
//			Integer i=new Integer(1);
			
//			VolatileTest v1=new VolatileTest(1);
			
//			for(int i=0;i<10000;i++){
//				a1=new A();
//			}
//			System.out.println("flag:"+flag);
			
//			arr[0]=a1;
			
			
//			map.put("a", "a");
		}
		
	}

}
