package staticProxy;

public class HisDady implements People {
	
	ZhangSan zs;
	
	public HisDady(ZhangSan zs) {
		this.zs = zs;
	}

	public void zhaoduixiang() {
		before();
		
		zs.zhaoduixiang();
		
		after();
	}
	
	private void before() {
		System.out.println("老子是ZhangSan的老子，先要过老子这关，要文凭，要家境！！！");
	}
	
	private void after() {
		System.out.println("就说明这么姑娘是一个号姑娘！");
	}
}
