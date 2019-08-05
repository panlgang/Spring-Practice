package com.github.excellent01.xmlaop;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @auther plg
 * @date 2019/8/1 15:33
 */
public class RealSubject implements ISubject {
    public void work1() {
        System.out.println("执行真实业务1...");
    }

    public void work2() {
        System.out.println("执行真实业务2...");
    }
}
