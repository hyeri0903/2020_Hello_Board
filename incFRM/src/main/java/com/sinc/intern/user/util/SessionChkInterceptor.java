package com.sinc.intern.user.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionChkInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("session interceptor preH ~~");
		HttpSession session = request.getSession() ;
		
		if(session.getAttribute("loginUSer") == null) {
			System.out.println("session is null");
			//response.sendRedirect("/loginForm.do");
			////////////////// add start
			String uri = request.getRequestURI() ;
			String query = request.getQueryString() ;
			String path = uri;
			if(request.getMethod().equalsIgnoreCase("get")) {
				path = uri + "?" + query ;
			} 
			
			session.setAttribute("dest", path);
			///////////////////// end
			response.sendRedirect("/loginForm.do");
			return false;
		}
		return true ;
	}
}
