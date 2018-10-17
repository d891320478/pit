package com.htdong.asm.test;

/**
 *
 * @author htdong
 * @date 2018年10月17日 下午3:03:16
 */

public class TestClass {
    private String sql = "select * from tables";

    public TestClass() {

    }

    public TestClass(String sql) {
        super();
        this.sql = sql;
    }

    public void operation() {
        System.out.println("shihuan operation...");
    }

    public int executeInternal() {
        System.out.println("shihuan executeInternal...");
        if (true) {
            System.out.println(this.sql);
            return 2;
        }
        return 3;
    }
}
