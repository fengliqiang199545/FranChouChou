package test.customMapperTest;

import cn.com.taiji.entity.UserloginCustom;
import cn.com.taiji.mapper.UserloginCustomMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserloginCustomMapperTest {
    private ApplicationContext applicationContext;

    @Before
    public void setup() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml","spring/applicationContext-servlet.xml"});

    }

    @Test
    public void findByName() throws Exception{
        UserloginCustomMapper userloginCustomMapper = (UserloginCustomMapper) applicationContext.getBean("userloginCustomMapper");

        UserloginCustom userloginCustom =  userloginCustomMapper.findByName("10001");

        System.out.println(userloginCustom);




    }
}
