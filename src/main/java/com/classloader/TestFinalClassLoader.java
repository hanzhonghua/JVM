package com.classloader;

import java.util.Random;

/**
 * 下面代码中调用那个变量可以执行静态代码块
 * 调用常量a和c，因为加上final后是常量，所以调用变量b不会加载类，因为1*2在编译期
 * 编译器就可以计算出来，而new Random().nextInt(10)需要在运行时才可以
 * 知道确切的值，所以调用c会初始化类，那为什么静态代码块只执行了一次呢？JVM规定的，静态
 * 代码块在运行期间只会被加载一次，除非卸载之后重新加载
 */
class FinalTest1 {
	public static int a = 1;
	public final static int b = 1 * 2;
	public final static int c = new Random().nextInt(10);
	static{
		System.out.println("我是静态代码块！！");
	}
	{
		System.out.println("代码块");
	}
}

public class TestFinalClassLoader {

	public static void main(String[] args) {
		System.out.println(FinalTest1.a);
		System.out.println(FinalTest1.b);
		System.out.println(FinalTest1.c);
	}
}
