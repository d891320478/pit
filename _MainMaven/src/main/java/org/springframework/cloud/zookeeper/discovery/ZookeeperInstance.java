package org.springframework.cloud.zookeeper.discovery;

import java.util.Map;

/**
 * 占位符类，用于解决 Curator 反序列化 Spring Cloud Zookeeper 数据时的 ClassNotFoundException
 * 这个类不需要实现任何功能，只需要存在即可让 Jackson 能够反序列化数据
 */
public class ZookeeperInstance {
    private String id;
    private String name;
    private Map<String, String> metadata;

    public ZookeeperInstance() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
