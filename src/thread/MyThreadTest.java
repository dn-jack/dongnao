package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThreadTest {

	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// 代表我们程序中的临界资源
	String flag[] = { "true" };

	int count = 0;

	public static void main(String[] args) {
		MyThreadTest test = new MyThreadTest();
		
		test.new BThread().start();
		
		test.new AThread().start();
		test.new AThread().start();
		test.new AThread().start();
		test.new AThread().start();
	}

	// 负责验证这个wait方法
	class AThread extends Thread {

		public void run() {
			while (flag[0] != "false") {
				if (count >= 100) {
					try {
						System.out.println("线程名称："
								+ Thread.currentThread().getName() + " 执行时间 ： "
								+ df.format(new Date()) + " 开始等待了");
						long curTime = System.currentTimeMillis();
						
						synchronized(flag) {
							flag.wait();
						}
						
						System.out.println("线程名称："
								+ Thread.currentThread().getName() + " 执行时间 ： "
								+ df.format(new Date()) + " 等待时间为："
								+ (System.currentTimeMillis() - curTime));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("线程名称："
							+ Thread.currentThread().getName() + " 执行时间 ： "
							+ df.format(new Date()) + "count:" + count++);
				}
			}
		}

	}

	// 负责唤醒所有的A线程类
	class BThread extends Thread {
		
		public void run() {
			
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("线程名称："
					+ Thread.currentThread().getName() + " 执行时间 ： "
					+ df.format(new Date()) + " 我要唤醒A线程");
			
			synchronized(flag) {
				flag[0] = "false";
				flag.notifyAll();
			}
		}

	}

}
