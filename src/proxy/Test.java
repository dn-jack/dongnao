package proxy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

public class Test {

	public static void main(String[] args) throws Throwable {
		People people = (People) Proxy.newProxyInstance(
				People.class.getClassLoader(), new Class[] { People.class },
				new ProxyHandler(new ZhangSan()));
		System.out.println("JDK的动态代理");
		people.eat();
		
		System.out.println("\r\n");

		// System.out.println(people.getClass().getName());

		// createProxyClassFile();

		People people1 = (People) MyProxy.createProxyInstance(People.class
				.getClassLoader(), People.class, new MyProxyHandler(
				new ZhangSan()));
		
		System.out.println("自己写的动态代理!");
		people1.eat();
	}

	// 还原我们的代理类
	public static void createProxyClassFile() {
		byte[] data = ProxyGenerator.generateProxyClass("$Proxy0",
				new Class[] { People.class });

		try {
			FileOutputStream out = new FileOutputStream("$Proxy0.class");
			out.write(data);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
