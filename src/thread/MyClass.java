package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyClass {
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void b() {
		System.out.println("�߳����ƣ�" + Thread.currentThread().getName()
				+ " ִ��ʱ�� �� " + df.format(new Date()));
		
		try {
			Thread.sleep(3000);
			
			System.out.println("�߳����ƣ�" + Thread.currentThread().getName()
					+ " ִ��ʱ�� �� " + df.format(new Date()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
