package staticProxy;

public class Test {

	public static void main(String[] args) {
		People people1 = new ZhangSan();
		
		People people = new HisDady(new ZhangSan());
		
		people1.zhaoduixiang();
		people.zhaoduixiang();
	}

}
