package test.serviceTest;

import cn.com.taiji.entity.CourseCustom;
import cn.com.taiji.service.CourseService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CourseServiceImplTest {
    private ApplicationContext applicationContext;

    @Before
    public void setup() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml"});
    }

    @Test
    public void findByTeacherID() throws Exception{
        CourseService courseService =  (CourseService) applicationContext.getBean("courseServiceImpl");

        List<CourseCustom> list =  courseService.findByTeacherID(1002);

        System.out.println(list);
    }
}
