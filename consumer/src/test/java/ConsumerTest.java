import com.qunar.hotel.api.Service.DemoService;
import com.qunar.hotel.api.bean.Param;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by easonlian on 16-7-12.
 */
public class ConsumerTest {

    private ClassPathXmlApplicationContext ctx = null;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext(new String[]{"consumer.xml"});
        ctx.start();
    }

    @Test
    public void test1() throws Exception {
        DemoService demoService = ctx.getBean(DemoService.class); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法
        String beanStr = demoService.echoBean(new Param());

        System.out.println(hello); // 显示调用结果
        System.out.println(beanStr);
    }
}
