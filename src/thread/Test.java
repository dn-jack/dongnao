package thread;



public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		StaticClass sc = new StaticClass();
		t.new MyThread(sc).start();
		t.new MyThread1(sc).start();
	}
	
	class MyThread extends Thread {
		StaticClass mytest;
		
		MyThread(StaticClass mytest) {
			this.mytest = mytest;
		}

		public void run() {
			StaticClass.c();
		}
	}
	
	class MyThread1 extends Thread {
		StaticClass mytest;
		
		MyThread1(StaticClass mytest) {
			this.mytest = mytest;
		}

		public void run() {
			StaticClass.a();
		}
	}
}
