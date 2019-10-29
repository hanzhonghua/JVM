package com.java8;

/**
 * @Description:
 * @Author: HanZhonghua
 * @Date: Create in 上午11:18 2019/10/29
 */
public class LambdaTest {

    public static void main(String[] args) {

        // 用了6行代码，实现sqlt(a * 100)，可以用lambda表达式替换
        Formual f= new Formual() {
            @Override
            public double calculate(int a) {
                return sqlt(a);
            }
        };
        //System.out.println(f.calculate(10));
        Formual ff = (int a) -> a*10;
        System.out.println(ff.calculate(100));
    }
}
