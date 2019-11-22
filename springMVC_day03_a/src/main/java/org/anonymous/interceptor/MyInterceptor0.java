package org.anonymous.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author child
 * 2019/4/21 22:09
 */
public class MyInterceptor0 implements HandlerInterceptor {
    @Override //在 控制器方法执行之前只从的方法 (请求时)
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandler0000...");

        //设置 false, 看结果
        return true; //true 代表放行, false 代表不放行
    }

    @Override //在 控制器方法执行之后执行 (响应回来:与 请求顺序相反) -- 控制器方法不执行,该方法也不会执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post0000....");
    }

    @Override //响应结束,且 preHandler 方法的返回值为 true, 执行该方法
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after0000...");
    }

}
