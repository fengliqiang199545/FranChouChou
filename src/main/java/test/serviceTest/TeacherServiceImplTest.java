package test.serviceTest;

import cn.com.taiji.entity.PagingVO;
import cn.com.taiji.entity.TeacherCustom;
import cn.com.taiji.service.TeacherService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TeacherServiceImplTest {
    private ApplicationContext applicationContext;

    @Before
    public void setup() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml"});
    }


    @Test
    public void findByPaging() throws  Exception{


        TeacherService teacherService = (TeacherService) applicationContext.getBean("teacherServiceImpl");

        List<TeacherCustom> list = teacherService.findByPaging(1);

        System.out.println(list);

    }
}