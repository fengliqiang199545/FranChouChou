package test.customMapperTest;

import cn.com.taiji.entity.PagingVO;
import cn.com.taiji.entity.TeacherCustom;
import cn.com.taiji.mapper.TeacherCustomMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TeacherCustomMapperTest {
    private ApplicationContext applicationContext;

    @Before
    public void setup()throws Exception{
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml","spring/applicationContext-servlet.xml"});
    }

    @Test
    public void findByPaging() throws Exception{
        TeacherCustomMapper teacherCustomMapper = (TeacherCustomMapper) applicationContext.getBean("teacherCustomMapper");

        PagingVO pagingVO =  new PagingVO();

        pagingVO.setToPageNo(1);

        List<TeacherCustom> list = teacherCustomMapper.findByPaging(pagingVO);

        System.out.println(list);
    }
}
