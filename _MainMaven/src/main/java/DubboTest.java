import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

import com.htdong.common.rpc.streamtest.StreamTestFacadeService;

public class DubboTest {

    public static void main(String[] args) throws IOException {
        System.setProperty("dubbo.registry.group", "dubbo");
        System.setProperty("dubbo.registry.address", "zookeeper://127.0.0.1:2181");
        System.setProperty("dubbo.protocol.name", "tri");

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

        RegistryConfig registry = new RegistryConfig("zookeeper://127.0.0.1:2181");

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