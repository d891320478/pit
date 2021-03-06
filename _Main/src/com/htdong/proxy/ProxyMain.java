package com.htdong.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

import com.htdong.proxy.handler.TestServiceProxyHandler;
import com.htdong.proxy.service.TestService;
import com.htdong.proxy.service.impl.TestServiceImpl;

/**
 *
 * @author htdong
 * @date 2018年4月20日 上午10:57:13
 */

public class ProxyMain {
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class<?>[] cla = new Class<?>[] { TestService.class };
        Object proxy = Proxy.newProxyInstance(TestService.class.getClassLoader(), cla,
                new TestServiceProxyHandler(new TestServiceImpl()));
        // ((TestService) proxy).test1(1);
        proxy.getClass().getMethod("test1", Integer.class).invoke(proxy, 110);
    }
}
