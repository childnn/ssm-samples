package org.anonymous.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author child
 * 2019/4/21 22:09
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override //在 控制器方法执行之前执行的方法(请求)
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandler...");
        return true; //true 代表放行, false 代表不放行
    }

    @Override //在 控制器方法执行之后执行 (响应回来)
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post....");
    }

    @Override //响应结束,且 preHandler 方法的返回值为 true, 执行该方法
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after...");
    }

}
