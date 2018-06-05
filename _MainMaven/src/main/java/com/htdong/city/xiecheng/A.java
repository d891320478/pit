package com.htdong.city.xiecheng;

/**
 *
 * @author htdong
 * @date 2018年6月2日 下午4:48:34
 */

public class A {
    public Long code;
    public String name;
    public Long pre;
    public Long id;
    public Long preId;
    public Integer level;
    public String addr;

    public A(Long code, String name, Long pre, Integer level) {
        this(code, name, pre, null, null, level, null);
    }

    public A(Long code, String name, Long pre, Long id, Long preId, Integer level, String addr) {
        this.code = code;
        this.name = name;
        this.pre = pre;
        this.level = level;
        this.preId = preId;
        this.id = id;
        this.addr = addr;
    }
}