package test.serviceTest;

import cn.com.taiji.entity.College;
import cn.com.taiji.service.CollegeService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CollegeServiceImplTest {
    private ApplicationContext applicationContext;

    @Before
    public void setup() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml"});
    }

    @Test
    public void finall() throws  Exception{
        CollegeService collegeService = (CollegeService) applicationContext.getBean("collegeServiceImpl");
        List<College> list=collegeService.finAll();
        System.out.println(list);
    }
}
