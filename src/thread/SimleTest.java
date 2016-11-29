package thread;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimleTest {
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {
//		SimleTest st = new SimleTest();
//		MyTest mt = st.new MyTest();
//		
//		st.new MyThread(mt).start();
//		st.new MyThread(mt).start();
//		
//		st.new MyThread(st.new MyTest()).start();
//		st.new MyThread(st.new MyTest()).start();
//		
//		st.new MyThread(mt).start();
//		st.new MyThread1(mt).start();
		
		System.out.println(SimleTest.class.getResource("thread"));
		System.out.println(SimleTest.class.getResource("/thread/ggh"));
		
		URL url = SimleTest.class.getResource("/thread/ggh");
		String fileName = url.getFile();
		System.out.println(fileName);
		
		File file = new File(fileName);
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		for(String fileName1 : file.list()) {
			
		}
		
	}
	
	class MyTest {
		public void a() {
			System.out.println("线程名称："
					+ Thread.currentThread().getName() + " 执行时间 ： "
					+ df.format(new Date()) + " method : a()");
		}
		
		public synchronized void c() {
			System.out.println("线程名称："
					+ Thread.currentThread().getName() + " 执行时间 ： "
					+ df.format(new Date()) + " method : c()");
		}
		
		public synchronized void b() {
			System.out.println("线程名称："
					+ Thread.currentThread().getName() + " 执行时间 ： "
					+ df.format(new Date()) + " method : b()");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	class MyThread extends Thread {
		MyTest mytest;
		
		MyThread(MyTest mytest) {
			this.mytest = mytest;
		}

		public void run() {
			mytest.b();
		}
	}
	
	class MyThread1 extends Thread {
		MyTest mytest;
		
		MyThread1(MyTest mytest) {
			this.mytest = mytest;
		}

		public void run() {
			mytest.c();
		}
	}

}
