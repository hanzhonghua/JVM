package com.java8;

/**
 * @Description: java8提供了default关键字，可以在接口中定义实现
 * @Author: HanZhonghua
 * @Date: Create in 上午11:17 2019/10/29
 */
public interface Formual {

    double calculate(int a);
    default double sqlt(int a){
        return a * 100;
    }

}
