package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//������
public class ProxyHandler implements InvocationHandler {
	
	People people = null;
	
	public ProxyHandler(People people) {
		this.people = people;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before();
		
		method.invoke(people, null);
		
		after();
		
		return null;
	}
	
	private void before() {
		System.out.println("�Է�֮ǰҪϴ�֣�");
	}
	
	private void after() {
		System.out.println("���극�Ժ�Ҫϴ�룡");
	}
}
