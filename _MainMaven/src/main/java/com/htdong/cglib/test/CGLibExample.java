package com.htdong.cglib.test;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.objectweb.asm.Type;

import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InterfaceMaker;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibExample {

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {

        // 定义一个参数是字符串类型的setCreatedAt方法
        InterfaceMaker im = new InterfaceMaker();
        im.add(new Signature("setCreatedAt", Type.getType(Date.class), new Type[] { Type.getType(String.class) }), null);

        Class myInterface = im.create();

        Enhancer enhancer = new Enhancer();
        // enhancer.setSuperclass(ExampleBean.class);
        enhancer.setInterfaces(new Class[] { myInterface });
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

                // ExampleBean bean = (ExampleBean) obj;

                // 调用字符串类型的setCreatedAt方法时，转换成Date型后调用Setter
                if (method.getName().startsWith("setCreatedAt") && args[0] != null && args[0] instanceof String) {

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    Date date = null;
                    try {
                        date = sdf.parse((String) args[0]);
                    } catch (final Exception e) {
                        /* nop */ }
                    // bean.setCreatedAt(date);
                    System.err.println(args[0]);
                    return date;

                }
                return proxy.invokeSuper(obj, args);

            }
        });

        // 生成一个Bean
        // ExampleBean bean = (ExampleBean) enhancer.create();
        // bean.setId(999);
        Object obj = enhancer.create();
        try {
            Method method = obj.getClass().getMethod("setCreatedAt", new Class[] { String.class });
            Date rlt = (Date)method.invoke(obj, new Object[] { "20160531" });
            System.out.println(rlt);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}