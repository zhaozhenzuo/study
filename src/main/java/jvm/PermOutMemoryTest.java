package jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class PermOutMemoryTest {

	public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {

		// String path="/Users/zhaozhenzuo/Documents/temp/test.jar";
		// URL url= new File(path).toURL();
		// URL[] urls = {url};
		//
		//
		// //无限创建新的URLClassLoader，并且让其加载指定的一个大类
		// while(true){
		// URLClassLoader cl = new URLClassLoader(urls);
		// cl.loadClass("com.test.testTemp.App");
		// }

		Map<String, Object> map = new HashMap<String, Object>();

		ReferenceQueue queue = new ReferenceQueue();
		PhantomReference pr = new PhantomReference(map, queue);

		Object object = queue.poll();
		System.out.println(object);

		Byte[] bytes = new Byte[1024 * 1024 * 10];

		map.put("a", bytes);

		System.out.println("after:" + object);

	}

}
