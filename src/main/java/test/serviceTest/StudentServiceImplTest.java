package test.serviceTest;

import cn.com.taiji.entity.Student;
import cn.com.taiji.entity.StudentCustom;
import cn.com.taiji.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StudentServiceImplTest {
    private ApplicationContext applicationContext;

    @Before
    public void setup() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml"});
    }

    @Test
    public void updataById() throws Exception{
        StudentService studentService = (StudentService) applicationContext.getBean("studentServiceImpl");

        StudentCustom studentCustom = new StudentCustom();
        studentCustom.setUserid(10004);
        studentCustom.setUsername("小左");

        //指定时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        //指定一个日期
        Date date = dateFormat.parse("1995-04-05");

        studentCustom.setBirthyear(date);

        studentCustom.setCollegeid(1);

        studentCustom.setSex("男");

        studentCustom.setGrade(new Date());

        studentService.updataById(10004,studentCustom);

        System.out.println("修改成功");

    }

    @Test
    public void removeById() throws Exception{
        //获取student的服务类bean
        StudentService studentService = (StudentService) applicationContext.getBean("studentServiceImpl");

        studentService.removeById(10004);

        System.out.println("删除成功");

    }

    @Test
    public void findByPaging() throws Exception{
        StudentService studentService = (StudentService) applicationContext.getBean("studentServiceImpl");

        List<StudentCustom> list =  studentService.findByPaging(1);

        System.out.println(list);

        System.out.println("查询成功");
    }

    @Test
    public void save() throws Exception{
        StudentCustom studentCustom = new StudentCustom();
        //设置StudentCustom 属性
        studentCustom.setUserid(11122);
        studentCustom.setUsername("小强");
//        studentCustom.setBirthyear(new Date(1996, 9, 2));

        //指定时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d");
        // 指定一个日期
        Date date = dateFormat.parse("1995-04-05");
        studentCustom.setBirthyear(date);

        studentCustom.setCollegeid(1);
        studentCustom.setSex("男");
        studentCustom.setGrade(new Date());

        StudentService studentService = (StudentService) applicationContext.getBean("studentServiceImpl");

        studentService.save(studentCustom);

        System.out.println("保存成功");
    }

    @Test
    public void getCountStudent() throws Exception{
        StudentService studentService = (StudentService) applicationContext.getBean("studentServiceImpl");

        int count = studentService.getCountStudent();

        System.out.println(count);
    }

    @Test
    public void findById() throws Exception {
        StudentService studentService = (StudentService) applicationContext.getBean("studentServiceImpl");

        StudentCustom studentCustom = studentService.findById(11111);

        System.out.println(studentCustom);
    }

    @Test
    public void findByName() throws Exception{
        StudentService studentService = (StudentService) applicationContext.getBean("studentServiceImpl");

        List<StudentCustom> list = studentService.findByName("小");

        System.out.println(list);
    }
}
