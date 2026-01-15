import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.htdong.common.rpc.streamtest.StreamTestFacadeService;

public class DubboTest {

    public static void main(String[] args) throws IOException {
        // 配置 Jackson 忽略未知类型（解决 Curator 反序列化 Spring Cloud Zookeeper 数据的问题）
        // Curator 使用 Jackson 反序列化 ServiceInstance，但数据中包含 Spring Cloud 的类型信息
        // 由于 Curator 内部创建自己的 ObjectMapper，我们需要通过其他方式解决
        // 方案：创建一个占位符类来避免 ClassNotFoundException
        try {
            // 配置全局默认的 ObjectMapper 行为（虽然 Curator 可能不使用，但尝试配置）
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        } catch (Exception e) {
            System.err.println("Failed to configure Jackson: " + e.getMessage());
        }

        // 关键配置：完全禁用应用级服务发现，强制使用接口级服务发现
        // 方式1：通过系统属性强制设置（最高优先级，必须在创建任何 Dubbo 对象之前设置）
        System.setProperty("dubbo.application.register-mode", "interface");
        System.setProperty("dubbo.registry.enable-application-scope", "false");
        System.setProperty("dubbo.registry.services-path", ""); // 清空应用级服务发现路径
        System.setProperty("dubbo.registry.group", "dubbo"); // 设置注册中心组
        System.setProperty("dubbo.service-discovery.migration", "false"); // 禁用服务发现迁移

        ReferenceConfig<StreamTestFacadeService> ref = new ReferenceConfig<>();
        ref.setInterface(StreamTestFacadeService.class);
        ref.setTimeout(3000);
        ref.setProtocol(CommonConstants.TRIPLE);

        // 在 ReferenceConfig 中也设置参数，确保只使用接口级服务发现
        Map<String, String> refParams = new HashMap<>();
        refParams.put("register-mode", "interface");
        refParams.put("enable-application-scope", "false");
        ref.setParameters(refParams);

        ApplicationConfig application = new ApplicationConfig("dubbo-stream-client");
        application.setMetadataType("local"); // 使用本地元数据，不依赖远程元数据服务

        // 方式2：通过 ApplicationConfig 设置
        try {
            application.setRegisterMode("interface");
        } catch (Exception e) {
            // 如果方法不存在，使用参数方式
            System.out.println("setRegisterMode method not available, using parameters");
        }

        Map<String, String> parameters = new HashMap<>();
        parameters.put("registry-type", "service"); // 使用接口级注册
        parameters.put("register-mode", "interface"); // 强制接口级注册模式
        parameters.put("enable-application-scope", "false"); // 禁用应用级作用域
        application.setParameters(parameters);

        // 方式3：使用 URL 字符串方式配置 RegistryConfig，确保只使用 /dubbo 路径
        // 关键：通过 URL 参数明确禁用应用级服务发现，强制使用接口级服务发现
        // 注意：path 参数必须放在 URL 中，而不是通过 setParameters
        String registryUrl = "zookeeper://127.0.0.1:2181" +
                "?path=/dubbo" + // 明确指定使用 /dubbo 路径（必须在 URL 中）
                "&group=dubbo" + // 设置组名
                "&register-mode=interface" + // 接口级注册模式
                "&enable-application-scope=false" + // 禁用应用级服务发现
                "&subscribe=true" + // 启用订阅
                "&register=false" + // 客户端不需要注册
                "&registry-type=service" + // 使用接口级注册类型
                "&services-path="; // 清空应用级服务发现路径（设置为空）

        RegistryConfig registry = new RegistryConfig(registryUrl);

        // 额外确保：通过 setParameters 再次设置关键参数
        Map<String, String> registryParams = new HashMap<>();
        registryParams.put("register-mode", "interface");
        registryParams.put("enable-application-scope", "false");
        registryParams.put("registry-type", "service");
        registry.setParameters(registryParams);

        // 打印配置信息用于调试
        System.out.println("=== Dubbo 配置信息 ===");
        System.out.println("Registry URL: " + registryUrl);
        System.out.println("Application register-mode: " + System.getProperty("dubbo.application.register-mode"));
        System.out.println(
                "Registry enable-application-scope: " + System.getProperty("dubbo.registry.enable-application-scope"));
        System.out.println("Registry path: /dubbo");
        System.out.println("======================");

        // 使用新的实例而不是单例，避免之前的配置影响
        DubboBootstrap bootstrap = DubboBootstrap.newInstance();
        bootstrap.application(application).registry(registry).reference(ref).start();

        StreamTestFacadeService service = ref.get();

        StreamObserver<String> stream = new StreamObserver<>() {

            @Override
            public void onNext(String data) {
                System.out.println(data);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("stream completed");
            }
        };

        service.sayHelloStream("hello world", stream);
        System.in.read();

        // 清理
        bootstrap.stop();
    }
}