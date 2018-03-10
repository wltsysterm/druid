import com.wlt.biz.service.test.IUserService;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 魏霖涛
 * @since 2018/3/8 0008
 */
public class Test {
    private static ApplicationContext context;
    @Autowired
    IUserService userService;
    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }
    @org.junit.Test
    public void test() {
//        IUserService userService = (UserServiceImpl)context.getBean("userServiceImpl");
//        List<User> list = userService.list();
//        System.out.println(list);
    }
}
