package com.springapp.mvc.interseptor;

import com.mysql.jdbc.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by richard on 15-12-4.
 * 拦截器， 需要实现接口，当中有三个方法.
 * 应用场景：
 * 统一日志处理拦截器，需要该拦截器prehandle一定要放行，并且将它放在拦截器链接的第一个位置.
 * 登陆认证拦截器，放在拦截器链接的第一个位置，权限校验拦截器放在登陆认证拦截器的后边(登陆认证成功后才可以去进行权限校验.)
 */
public class LoginInterceptor implements HandlerInterceptor{

    /**
     * 进入handle方法之前执行该方法. 如果false不向下执行，true则继续；
     * 应用场景比如，授权登陆，
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        //登陆拦截器.
        //获取当前地址url
        String url = request.getRequestURI();
        System.out.println("longInterceptor preHandle url is:" + url);
        if (url.contains("login")) {
            return true;
        }

        //从session获取用户信息
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println("longInterceptor preHandle username is:" + username);
        if (!StringUtils.isNullOrEmpty(username)) {
            return true;
        }

        //如果没有成功登陆那么需要跳转到登陆页面
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);

        return false;

    }


    /**
     * 进入handle方法之后，返回ModelAndView之前触发.
     * 可以统一在这里指定视图. 统一的异常处理. 统一的日志处理.
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {

        System.out.println("HandlerInterceptor1....postHandle");

    }

    /**
     * handle方法执行之后触发.
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

        System.out.println("HandlerInterceptor1....afterCompletion");

    }
}
