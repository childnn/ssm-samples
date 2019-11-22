package org.anonymous.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author child
 * 2019/4/21 22:30
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override //在控制器方法之前执行的方法
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登录
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        System.out.println(user);
        if (user == null) {
            System.out.println("未登录..");
            //跳转登录页面
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        }
        //登录就放行
        return true;
    }
}
