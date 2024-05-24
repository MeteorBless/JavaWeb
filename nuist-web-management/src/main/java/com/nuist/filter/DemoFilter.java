package com.nuist.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override // 初始化方法，只调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
        System.out.println("初始化方法被执行");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截到了请求");
        // 放行
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("执行放行之后的逻辑~~~");
    }

    @Override // 销毁方法，只调用一次
    public void destroy() {
//        Filter.super.destroy();
        System.out.println("销毁方法被执行");
    }
}
