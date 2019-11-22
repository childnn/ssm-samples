package org.anonymous.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author child
 * 2019/4/21 21:43
 * 异常处理器: 只要程序异常,就会执行该方法
 */
public class HandMyException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView mv = new ModelAndView();
        if (ex instanceof MyException) {
            //判断具体是哪一层出错
            mv.addObject("msg", "service 层 未知错误...");
        } else {
            mv.addObject("msg", "xxxx层 未知错误...");
        }
        //请求转发
        mv.setViewName("error");

        return mv;
    }
}
