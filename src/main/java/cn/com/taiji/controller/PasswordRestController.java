package cn.com.taiji.controller;

import cn.com.taiji.entity.Userlogin;
import cn.com.taiji.exception.CustomException;
import cn.com.taiji.service.UserloginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class PasswordRestController {
    @Resource(name = "userloginServiceImpl")
    private UserloginService userloginService;

    //reset the password
    @RequestMapping(value = "/passwordRest",method = RequestMethod.POST)
    public String passwordRest(String oldPassword , String password)throws Exception{
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        Userlogin userlogin = userloginService.findByName(username);

        if (!oldPassword.equals(userlogin.getPassword())){
            throw new CustomException("旧密码不正确");
        }else {
            userlogin.setPassword(password);
            userloginService.updateByName(username,userlogin);
        }
        return "redirect:/logout";
    }
}
