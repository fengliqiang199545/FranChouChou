package cn.com.taiji.exception;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomExceptionResolver implements HandlerExceptionResolver{
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView modelAndView = new ModelAndView();

        CustomException customException;

        if(e instanceof CustomException){
            customException = (CustomException) e;
        }else if(e instanceof UnknownAccountException){
            //用户名错误异常
            modelAndView.addObject("message","没有改用户");
            modelAndView.setViewName("error");
            return modelAndView;
        }else if (e instanceof IncorrectCredentialsException){
            //密码错误异常
            modelAndView.addObject("message","密码错误");
            modelAndView.setViewName("error");
            return modelAndView;
        }else {
            e.printStackTrace();

        }
        modelAndView.addObject("message","未知错误！");
        modelAndView.setViewName("error");
        return modelAndView;

    }
}
