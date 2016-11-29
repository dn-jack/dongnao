package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StaticClass {
	
	static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void a() {
		System.out.println("线程名称："
				+ Thread.currentThread().getName() + " 执行时间 ： "
				+ df.format(new Date()) + " method : a()");
	}
	
	public static synchronized void b() {
		System.out.println("线程名称："
				+ Thread.currentThread().getName() + " 执行时间 ： "
				+ df.format(new Date()) + " method : b()");
	}
	
	public static synchronized void c() {
		System.out.println("线程名称："
				+ Thread.currentThread().getName() + " 执行时间 ： "
				+ df.format(new Date()) + " method : c()");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
