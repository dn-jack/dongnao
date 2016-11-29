package proxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class MyProxy {
	
	static String rt = "\r\n";

	public static Object createProxyInstance(ClassLoader loader, Class intf,
			MyInvocationHandler hanlder) {
		try {
		Method[] methods = intf.getMethods();
		
		//1������һ��java�ļ��������ķ�ʽ����һ��java�ļ�
		String proxyClass = "package proxy;" + rt
				+ "import java.lang.reflect.Method;" + rt
				+ "public class $Proxy0 implements " + intf.getName() + "{" + rt
				+ "MyInvocationHandler h;" + rt
				+ "public $Proxy0(MyInvocationHandler h) {" + rt
				+ "this.h = h;" + rt + "}"
				+ getMethodString(methods,intf) + rt + "}";
		
		//2\ ���������ļ�
		String fileName = "F:/wt_dongnao/dongnao/src/proxy/$Proxy0.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(proxyClass);
		fw.flush();
		fw.close();
		
		
		//3������java�ļ�
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		
		t.call();
		
		fileMgr.close();
		
		f.delete();
		
		
		//��class���ص��ڴ�
		MyClassLoader loader1 = new MyClassLoader("F:/wt_dongnao/dongnao/src/proxy/");
		
		Class proxy0Class = loader1.findClass("$Proxy0");
		
		File classFile = new File("F:/wt_dongnao/dongnao/src/proxy/$Proxy0.class");
		if(classFile.exists()) {
			classFile.delete();
		}
		Constructor m = proxy0Class.getConstructor(MyInvocationHandler.class);
		
		Object o = m.newInstance(hanlder);
		
		return o;
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static String getMethodString(Method[] methods,Class intf) {
		
		String proxyMe = "";
		
		for(Method method : methods) {
			proxyMe += "public void " + method.getName() + "() throws Throwable {" + rt
					+ "Method md = " + intf.getName() + ".class.getMethod(\"" + method.getName()
					+ "\",new Class[]{});" + rt
					+ "this.h.invoke(this,md,null);" + rt + "}" + rt;
		}
		
		return proxyMe;
	}
}
