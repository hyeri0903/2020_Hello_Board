package com.sinc.intern.user.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("login interceptor postHandler ~~~~~~~~~~~~~~~~");
		ModelMap model = modelAndView.getModelMap() ;
		//System.out.println(model.get("loginUserModel").getClass() ) ;
		Object obj = model.get("loginUserModel") ;
		if(obj != null) {
			HttpSession session = request.getSession() ;
			session.setAttribute("loginUser", obj);
			
			Object destObj = session.getAttribute("dest");
			response.sendRedirect(destObj != null ? (String)destObj : "/main.do");
			
		}
	}
}
