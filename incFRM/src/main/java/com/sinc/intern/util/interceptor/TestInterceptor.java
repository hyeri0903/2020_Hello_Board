package com.sinc.intern.util.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("test interceptor preHandler ~~~");
		HandlerMethod	method = (HandlerMethod)handler;
		Method			methodObj = method.getMethod();
		
		System.out.println("Bean : " + method.getBean().getClass());
		System.out.println("Method : " + methodObj);
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("test interceptor postHandler ~~~");
	
	}
}
