package com.jv.filter;

import com.jv.utils.LoginHelper;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.*;
import java.io.IOException;

public class LoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (LoginHelper.ifLogined(servletRequest,servletResponse)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            //TODO:重定向到登陆了页面。出去某些特定的页面（不如说登录页面）
        }
    }

    @Override
    public void destroy() {

    }
}
