package cn.com.taiji.controller;

import cn.com.taiji.entity.Userlogin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class LoginController {
    //登录跳转
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public String loginUI() throws Exception{
        return "../../login";
    }

    //登录表单处理
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Userlogin userlogin) throws Exception{
        //shiro实现登录功能
        UsernamePasswordToken token =  new UsernamePasswordToken(userlogin.getUsername(),userlogin.getPassword());

        Subject subject = SecurityUtils.getSubject();

        subject.login(token);

        if (subject.hasRole("admin")){
            return "redirect:/admin/showStudent";
        }else if (subject.hasRole("teacher")){
            return "redirect:/teacher/showCourse";
        }else if (subject.hasRole("student")){
            return "redirect:/student/showCourse";
        }
        return "/login";
    }
}
