import com.atguigu.framework.context.ApplicationContext;
import com.atguigu.framework.context.support.ClassPathXmlApplicationContext;
import com.atguigu.service.UserService;
import org.junit.Test;

/**
 * @Classname SpringTest
 * @Description TODO
 * @Date 2022/2/10 11:38
 * @Author Administrator
 * @Version 1.0.0
 */
public class SpringTest {
    @Test
    public void test1() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.add();
    }
}
