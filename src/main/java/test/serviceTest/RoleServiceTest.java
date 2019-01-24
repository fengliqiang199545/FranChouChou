package test.serviceTest;

import cn.com.taiji.service.RoleService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RoleServiceTest {
    private ApplicationContext applicationContext;

    @Before
    public  void setup() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml"});
    }

    @Test
    public void findByid() throws Exception{
        RoleService roleService = (RoleService) applicationContext.getBean("roleServiceImpl");
        System.out.println(roleService.findByid(2));
    }
}
