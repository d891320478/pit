package com.htdong.proxy.service.impl;

import com.htdong.proxy.service.TestService;

/**
 *
 * @author htdong
 * @date 2018年4月20日 上午10:59:14
 */

public class TestServiceImpl implements TestService {

    @Override
    public void test(Integer a) {
        System.out.println("success" + a);
    }

}
