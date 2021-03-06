package com.sinc.intern.user.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinc.intern.user.model.vo.UserDTO;
import com.sinc.intern.user.service.UserService;

@Controller
public class UserCtrl {
	
	@Resource(name = "userS")
	private UserService service ;
	
	@RequestMapping("/loginForm.do") 
	public String loginForm() {
		System.out.println("user loginForm");
		return "user/login" ;
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST) 
	public void login(UserDTO dto, Model model) {
		System.out.println("user login dto : " + dto);
		Object user = service.login(dto);
		if(user != null)
		{
			model.addAttribute("loginUserModel", user) ;
		}
		//return "redirect:/main.do" ;
	}
	
	@RequestMapping("/logout.do") 
	public String logout() {
		System.out.println("user logout");
		return "redirect:/main.do" ;
	}
	
	/*
	@RequestMapping("/login.do")
	// file name 또는 새로운 요청의 url을 리턴해 준다. 리턴값은 view가 받는다
	public String login(UserDTO dto) {
		System.out.println("ctrl login");
		System.out.println("UserDTO : " + dto);
		return "home";
		
	}
	@RequestMapping("/logout.do")
	public void logout() {
		System.out.println("ctrl logout");
		
		
	}
	@RequestMapping("/join.do")
	public ModelAndView join(ModelAndView mv) {
		System.out.println("ctrl join");
		mv.addObject("msg", "Hi, JSLIM") ;
		mv.setViewName("home");
		return null;
		
	}
	
	@RequestMapping("/search.do")
	public String search(Model model) {
		System.out.println("ctrl search");
		model.addAttribute("msg", "using model~~~") ;
		return "home";
		
	}
	
	@RequestMapping("/ajax.do")
	@ResponseBody
	public UserVO ajax() {
		System.out.println("ctrl ajax");
		return new UserVO("jslim", "jslim", "임정섭", 1000, "EMART") ;
	}
	*/
}



