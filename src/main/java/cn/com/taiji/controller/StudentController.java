package cn.com.taiji.controller;

import cn.com.taiji.entity.CourseCustom;
import cn.com.taiji.entity.PagingVO;
import cn.com.taiji.entity.SelectedCourseCustom;
import cn.com.taiji.entity.StudentCustom;
import cn.com.taiji.exception.CustomException;
import cn.com.taiji.service.CourseService;
import cn.com.taiji.service.SelectedCourseService;
import cn.com.taiji.service.StudentService;
import cn.com.taiji.service.impl.CourseServiceImpl;
import cn.com.taiji.service.impl.SelectedCourseServiceImpl;
import cn.com.taiji.service.impl.StudentServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import org.apache.shiro.subject.Subject;
import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

    @Resource(name = "studentServiceImpl")
    private StudentService studentService;

    @Resource(name = "selectedCourseServiceImpl")
    private SelectedCourseService selectedCourseService;

    @RequestMapping(value = "/showCourse")
    public String showCourse(Model model,Integer page) throws Exception{
        List<CourseCustom> list = null;

        PagingVO pagingVO = new PagingVO();

        pagingVO.setTotalCount(courseService.getCountCouse());

        if (page == null || page == 0){
            pagingVO.setToPageNo(1);
            list = courseService.findByPaging(1);
        }else{
            pagingVO.setToPageNo(page);
            list = courseService.findByPaging(page);
        }

        model.addAttribute("courseList",list);
        model.addAttribute("pagingVO",pagingVO);

        return "student/showCourse";
    }

    //选课操作
    @RequestMapping(value = "/stuSelectedCourse")
    public String stuSelectedCourse(int id) throws Exception{

        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();
        selectedCourseCustom.setCourseid(id);
        selectedCourseCustom.setStudentid(Integer.parseInt(username));

        SelectedCourseCustom s = selectedCourseService.findOne(selectedCourseCustom);

        if (s == null){
            selectedCourseService.save(selectedCourseCustom);
        }else {
            throw new CustomException("您已选择该课程，不能重复再选");
        }
        return "redirect:/student/selectedCourse";
    }

    //退课操作
    @RequestMapping(value = "/outCourse")
    public String outCourse(int id) throws Exception{
        Subject subject = SecurityUtils.getSubject();
        String username = (String)subject.getPrincipal();

        SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();
        selectedCourseCustom.setStudentid(Integer.parseInt(username));
        selectedCourseCustom.setCourseid(id);

        selectedCourseService.remove(selectedCourseCustom);

        return "redirect:/student/selectedCourse";
    }

    //查看已选课程
    @RequestMapping(value = "/selectedCourse")
    public String selectedCourse(Model model) throws Exception{
        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName((String)subject.getPrincipal());
        List<SelectedCourseCustom> list = studentCustom.getSelectedCourseList();

        model.addAttribute("selectedCourseList",list);

        return "student/selectedCourse";
    }

    //查看已修课程
    @RequestMapping(value = "/overCourse")
    public String overCourse(Model model) throws Exception{
        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName((String) subject.getPrincipal());

        List<SelectedCourseCustom> list = studentCustom.getSelectedCourseList();

        model.addAttribute("selectedCourseList", list);

        return "student/overCourse";
    }

    //修改密码
    @RequestMapping(value = "/passwordRest")
    public String passwordRest() throws Exception{
        return "student/passwordRest";
    }
}
