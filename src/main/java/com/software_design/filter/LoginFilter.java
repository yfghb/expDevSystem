package com.software_design.filter;

import com.alibaba.fastjson.JSON;
import com.software_design.controller.utils.R;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 在跳转后台控制页面前检查用户是否完成登入，若未完成则拦截并跳转登录页面。
 */
@Slf4j
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强转类型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取本次请求的url
        String requestURI = request.getRequestURI();

        if(!requestURI.contains("/user/get/") && request.getSession().getAttribute("user") == null){
            //未登录则返回NOT_LOGIN信息
            log.info("拦截到请求：{}",requestURI);
            response.getWriter().write(JSON.toJSONString(R.error("NOT_LOGIN")));
        } else filterChain.doFilter(request,response);//让通过


    }
}
