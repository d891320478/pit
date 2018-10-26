package com.htdong.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.htdong.proxy.service.TestService;

/**
 *
 * @author htdong
 * @date 2018年4月20日 上午11:02:25
 */

public class TestServiceProxyHandler implements InvocationHandler {

    private TestService testService;

    public TestServiceProxyHandler(TestService testService) {
        this.testService = testService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (Object iter : args) {
            System.err.println(iter);
        }
        return method.invoke(testService, args);
        // return null;
    }

}
