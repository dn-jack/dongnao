package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThreadTest {

	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// �������ǳ����е��ٽ���Դ
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

	// ������֤���wait����
	class AThread extends Thread {

		public void run() {
			while (flag[0] != "false") {
				if (count >= 100) {
					try {
						System.out.println("�߳����ƣ�"
								+ Thread.currentThread().getName() + " ִ��ʱ�� �� "
								+ df.format(new Date()) + " ��ʼ�ȴ���");
						long curTime = System.currentTimeMillis();
						
						synchronized(flag) {
							flag.wait();
						}
						
						System.out.println("�߳����ƣ�"
								+ Thread.currentThread().getName() + " ִ��ʱ�� �� "
								+ df.format(new Date()) + " �ȴ�ʱ��Ϊ��"
								+ (System.currentTimeMillis() - curTime));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("�߳����ƣ�"
							+ Thread.currentThread().getName() + " ִ��ʱ�� �� "
							+ df.format(new Date()) + "count:" + count++);
				}
			}
		}

	}

	// ���������е�A�߳���
	class BThread extends Thread {
		
		public void run() {
			
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("�߳����ƣ�"
					+ Thread.currentThread().getName() + " ִ��ʱ�� �� "
					+ df.format(new Date()) + " ��Ҫ����A�߳�");
			
			synchronized(flag) {
				flag[0] = "false";
				flag.notifyAll();
			}
		}

	}

}
