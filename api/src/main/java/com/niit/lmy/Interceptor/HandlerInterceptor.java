package com.niit.lmy.Interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        String token =  request.getHeader("token");
        System.out.println(token);

        return super.preHandle(request, response, handler);
    }
}
