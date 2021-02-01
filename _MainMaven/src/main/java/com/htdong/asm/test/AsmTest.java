package com.htdong.asm.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class AsmTest {

    private static MemoryClassLoader classLoader;

    public static void main(String[] args) throws IOException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {

        ClassReader cr = new ClassReader(TestClass.class.getName());
        ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);
        ClassVisitor cv = new ClassVisitor(Opcodes.ASM5, cw) {
        };
        cr.accept(cv, Opcodes.ASM5);

        // 新增加一个方法
        MethodVisitor mw = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "add", "(Ljava/lang/String;)V", null,
                null);
        // pushes the 'out' field (of type PrintStream) of the System class
        mw.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        // pushes the "Hello World!" String constant
        mw.visitLdcInsn("this is add method print!");
        // invokes the 'println' method (defined in the PrintStream class)
        mw.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        mw.visitInsn(Opcodes.RETURN);
        // this code uses a maximum of two stack elements and two local variables
        mw.visitMaxs(0, 0);
        mw.visitEnd();
        byte[] code = cw.toByteArray();
        classLoader = new MemoryClassLoader();
        Object obj = classLoader.defineClass(TestClass.class, code).getDeclaredConstructor(String.class).newInstance();
        Method m = obj.getClass().getMethod("add", String.class);
        for (int i = 0; i < m.getParameterTypes().length; ++i) {
            System.out.println(m.getParameterTypes()[i].getName());
        }
        m.invoke(obj, "123");
        System.out.println(obj.getClass().getName());
    }

    public static class MemoryClassLoader extends URLClassLoader {

        public MemoryClassLoader() {
            super(new URL[0], MemoryClassLoader.class.getClassLoader());
        }

        public Class<?> defineClass(Class<?> clazz, byte[] buf) {
            return defineClass(clazz.getName(), buf, 0, buf.length);
        }
    }

}