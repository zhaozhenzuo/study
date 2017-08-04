package jvm;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class PermOutMemoryTest {
	
	public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
		
		String path="/Users/zhaozhenzuo/Documents/temp/test.jar";
        URL url= new File(path).toURL(); 
        URL[] urls = {url};
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        //无限创建新的URLClassLoader，并且让其加载指定的一个大类
        while(true){
            URLClassLoader cl = new URLClassLoader(urls);
            cl.loadClass("com.test.testTemp.App");  
        }  
		
	}

}
