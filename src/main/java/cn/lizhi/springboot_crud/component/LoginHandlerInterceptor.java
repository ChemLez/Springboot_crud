package cn.lizhi.springboot_crud.component;

import cn.lizhi.springboot_crud.entity.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Admin user = (Admin) session.getAttribute("user");
        if (user != null) {
            return true;
        } else { // 未登录
            request.setAttribute("msg", "没有权限，请先登录"); // 设定提升信息
            request.getRequestDispatcher("/").forward(request, response); // 无权限，转发至首页.
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
