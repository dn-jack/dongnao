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
		System.out.println("������ZhangSan�����ӣ���Ҫ��������أ�Ҫ��ƾ��Ҫ�Ҿ�������");
	}
	
	private void after() {
		System.out.println("��˵����ô������һ���Ź��");
	}
}
