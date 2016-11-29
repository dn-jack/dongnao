package thread;

import java.text.SimpleDateFormat;

public class MyThread extends Thread {

	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {
		MyClass my = new MyClass();
		MyThread mythread1 = new MyThread(my);
		MyThread mythread2 = new MyThread(my);
		
		mythread1.start();
		mythread2.start();
		
	}
	
	
	MyClass myclass;
	
	MyThread(MyClass myclass) {
		this.myclass = myclass;
	}

	public void run() {
		while (true) {
			myclass.b();
		}
	}
}
