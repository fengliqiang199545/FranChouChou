package test.serviceTest;

import cn.com.taiji.entity.Userlogin;
import cn.com.taiji.service.UserloginService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserloginServiceImplTest {
    private ApplicationContext applicationContext;

    @Before
    public void setup() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml"});

    }

    @Test
    public void findByName() throws Exception {
        UserloginService userloginService = (UserloginService) applicationContext.getBean("userloginServiceImpl");
        Userlogin userlogin = userloginService.findByName("admin");
        System.out.println(userlogin);
    }
}
