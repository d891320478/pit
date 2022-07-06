package com.htdong.ace.test;

import com.shinemo.ace4j.Ace;
import com.shinemo.ace4j.client.AaceClientConfig;

public class AceTest {
    public static ConfigProxyService getService() {
        AaceClientConfig<ConfigProxyService> config = new AaceClientConfig<>();
        config.setInterfaceClass(ConfigProxyService.class);
        config.setUri("aace://10.0.19.105:16325/server?proxy=ConfigProxy");
        config.setEncryptMode(true);
        return Ace.getAndStart().serviceLookup().lookup(config);
    }
    
    public static void main(String[] args) {
        System.out.println(getService().getSecretConf("abc"));
    }
}