package com.classloader;

/**
 * 如下代码，请问会打印什么？打印结果是1，0结果有点出人意料，为什么呢，从类加载机制说起，首先在JVM中
 * 每个类或者接口在“首次主动使用”时候才会初始化，而主动使用的场景有以下几种：
 * 创建类的实例new
 * 访问类/接口的静态变量或者为静态变量赋值
 * 调用类的静态方法
 * 使用反射Class.forName("com.test...");
 * 初始化一个类的子类
 * 
 * 下面程序中，TestClassLoader1是主类，也就是启动类，在main方法中调用了Singleton.getInstance();
 * Singleton的静态方法，满足以上描述的首次主动使用，会初始化Singleton，在JVM类加载机制中，主要分为：
 * 加载，连接，初始化，其中连接有分为验证、准备、解析；在准备阶段，会为静态变量赋默认值，如int类型的默认值是0，
 * 而singleton的默认值是null，然后再初始化阶段，才会给静态变量真正赋值，此时代码户从上到下执行静态赋值，首先
 * singleton = new Singleton();调用构造方法，两个静态的int常量++，都成为1，代码继续向下执行，然后
 * count2 = 0;给count2赋值为0，覆盖了原来的1，所以结果就是：1，0
 * 
 * 此时如果将private static Singleton singleton = new Singleton();这段代码放到
 * 初始化变量count2之后，执行结果会是什么呢？推理一下。。。当然是1，1啦
 */
class Singleton {
	private static Singleton singleton = new Singleton();
	public static int count1;
	public static int count2 = 0;
	public static Singleton getInstance(){
		return singleton;
	}
	private Singleton(){
		count1++;
		count2++;
		
	};
}
public class TestClassLoader1 {

	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		System.out.println(s.count1);
		System.out.println(s.count2);
	}
}
