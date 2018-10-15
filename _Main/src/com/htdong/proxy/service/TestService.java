package com.htdong.proxy.service;

/**
 *
 * @author htdong
 * @date 2018年4月20日 上午10:58:31
 */

public interface TestService {
    void test(Integer a);
    
    default void test1(Integer a) {
        System.out.println("test1");
        test(a);
    }
}
