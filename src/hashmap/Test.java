package hashmap;


public class Test {
	
	static int init = 512;

	public static void main(String[] args) {
		new Test().chenyi2(init);
	}
	
	//ГЫвд2
	public void chenyi2(int n) {
		if(n > 10000) {
			System.out.print(" " + n);
			chuyi2(n);
			return;
		}
		
		System.out.print(" " + n);
		
		chenyi2(2 * n);
	}
	
	//Г§вд2
	public void chuyi2(int n) {
		if(n == init) {
			System.out.print(" " + n);
			return;
		}
		if(n < 10000)
		System.out.print(" " + n);
		chuyi2(n/2);
	}

}
