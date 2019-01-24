package test.serviceTest;

import cn.com.taiji.entity.SelectedCourseCustom;
import cn.com.taiji.service.SelectedCourseService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SelectedCourseServiceTest {
    private ApplicationContext applicationContext;

    @Before
    public void setup() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml"});
    }

    @Test
    public void findByCourseID() throws Exception{
        SelectedCourseService selectedCourseService = (SelectedCourseService) applicationContext.getBean("selectedCourseServiceImpl");

        List<SelectedCourseCustom> list = selectedCourseService.findByCourseID(1);

        System.out.println(list);
    }

    @Test
    public void findOne() throws Exception{
        SelectedCourseService selectedCourseService = (SelectedCourseService) applicationContext.getBean("selectedCourseServiceImpl");

        SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();

        selectedCourseCustom.setCourseid(2);
        selectedCourseCustom.setStudentid(10003);

        selectedCourseCustom  =  selectedCourseService.findOne(selectedCourseCustom);

        System.out.println(selectedCourseCustom);
    }
}
