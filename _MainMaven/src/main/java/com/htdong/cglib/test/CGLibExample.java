package com.htdong.cglib.test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.objectweb.asm.Type;

import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InterfaceMaker;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibExample {

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {

        Method[] methods = TestInterface.class.getDeclaredMethods();
        InterfaceMaker im = new InterfaceMaker();
        // 新增方法
        for (Method iter : methods) {
            Type[] exceptionTypes = new Type[iter.getExceptionTypes().length];
            Arrays.asList(iter.getExceptionTypes()).stream().map(Type::getType).collect(Collectors.toList())
                    .toArray(exceptionTypes);
            Type[] paramTypes = Arrays.copyOf(Type.getArgumentTypes(iter), iter.getParameterTypes().length + 1);
            paramTypes[paramTypes.length - 1] = Type.getType(AppType.class);
            im.add(new Signature(iter.getName(), Type.getType(iter.getReturnType()), paramTypes),
                    exceptionTypes.length == 0 ? null : exceptionTypes);
        }
        Class myInterface = im.create();

        Method[] ms = myInterface.getMethods();
        for (Method iter : ms) {
            System.out.print(iter.getReturnType().getName());
            System.out.print(" " + iter.getName() + "(");
            for (int i = 0; i < iter.getParameterTypes().length; ++i) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(iter.getParameterTypes()[i].getName());
            }
            System.out.println(");");
        }

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestInterface.class);
        enhancer.setInterfaces(new Class[] { myInterface });
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                for (Object i : args) {
                    System.err.println(i.getClass().getName());
                }
                return null;
            }
        });

        Object obj = enhancer.create();
        try {
            Method method = obj.getClass().getMethod("f", new Class[] { AppType.class });
            method.invoke(obj, new Object[] { new AppType() });
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}