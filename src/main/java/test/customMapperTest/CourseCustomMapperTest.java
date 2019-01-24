package test.customMapperTest;

import cn.com.taiji.entity.CourseCustom;
import cn.com.taiji.entity.PagingVO;
import cn.com.taiji.mapper.CourseCustomMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CourseCustomMapperTest {
    private ApplicationContext applicationContext;


    //加载应用上下文
    @Before
    public void setup()throws Exception{
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml","spring/applicationContext-servlet.xml"});
    }

    @Test
    public void findByPaging()throws Exception{
        CourseCustomMapper courseCustomMapper = (CourseCustomMapper) applicationContext.getBean("courseCustomMapper");

        PagingVO pagingVO = new PagingVO();

        pagingVO.setToPageNo(1);

        List<CourseCustom> list = courseCustomMapper.findByPaging(pagingVO);

        System.out.println(list);
    }
}
