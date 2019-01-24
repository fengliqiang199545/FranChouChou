package test.customMapperTest;

import cn.com.taiji.entity.PagingVO;
import cn.com.taiji.entity.StudentCustom;
import cn.com.taiji.mapper.StudentCustomMapper;
import cn.com.taiji.mapper.StudentMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentCustomMapperTest {
    private ApplicationContext applicationContext;

    @Before
    public void setup()throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml","spring/applicationContext-servlet.xml"});

    }

    @Test
    public void findByPaging() throws Exception{
        StudentCustomMapper studentCustomMapper = (StudentCustomMapper) applicationContext.getBean("studentCustomMapper");

       StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");

        PagingVO pagingVO = new PagingVO();

        pagingVO.setToPageNo(2);

        List<StudentCustom> list = studentCustomMapper.findByPaging(pagingVO);

        System.out.println(list);

    }

    @Test
    public void findStudentAndSelectCourseListById()throws Exception{

        StudentCustomMapper studentCustomMapper = (StudentCustomMapper) applicationContext.getBean("studentCustomMapper");

        StudentCustom studentCustom = studentCustomMapper.findStudentAndSelectCourseListById(10001);

        System.out.println(studentCustom);
    }
}
