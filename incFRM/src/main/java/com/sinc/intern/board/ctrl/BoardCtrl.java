//C:\Users\SSG\Documents\workspace-sts-3.9.2.RELEASE\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\incFRM\WEB-INF\views\board

package com.sinc.intern.board.ctrl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinc.intern.board.model.vo.BoardVO;
import com.sinc.intern.board.service.BoardService;

@Controller
public class BoardCtrl {
	@Resource(name = "boardS")
	private BoardService service ;
	
	@RequestMapping("/listPage.do") 
	public String list(Model model) {
		System.out.println("BoardCtrl execute");
		 List<Object> board = service.list();
		model.addAttribute("list", board) ;
		
		return "board/listPage" ;
	}
	
	@RequestMapping("/registerForm.do") 
	public String register() {
		System.out.println("BoardCtrl registerForm execute");

		return "board/register" ;
	}

	@RequestMapping("/register.do") 
	public String register(BoardVO bvo) {
		System.out.println("BoardCtrl register execute : " + bvo);
		int flag = service.register(bvo);
		System.out.println("register result flag : " + flag);
	
		if(flag == 1)
			return "redirect:/listPage.do" ;
		else
			return "redirect:/register.do" ;
	}
	
	@RequestMapping(value="/readPage.do", method=RequestMethod.GET)
	public String view(BoardVO obj, Model model) {
		System.out.println("BoardCtrl view execute");
		Object resultObj = service.view(obj);
		model.addAttribute("board", resultObj);
		
		return "board/readPage";
	}
	
	@RequestMapping("/remove.do") 
	public String remove(BoardVO obj) {
		System.out.println("BoardCtrl remove execute");
		int flag = service.remove(obj) ;
		System.out.println("register result : " + flag);
		
		return "redirect:/listPage.do" ;
	}
	
	@RequestMapping("/modify.do") 
	public String update(BoardVO obj) {
		System.out.println("BoardCtrl update execute");
		service.update(obj) ;
		
		return "redirect:/listPage.do" ;
	}
	
	@RequestMapping("/search.do")
	@ResponseBody   /*return 타입을 json으로 만들어줌*/
	public List<Object> search(String searchType, String searchKeyword, HashMap<String, String> map) {
		System.out.println("BoardCtrl search execute");
		map.put("searchType", searchType) ;
		map.put("searchKeyword", searchKeyword) ;
		
		List<Object> list = service.search(map) ;
	
		return list;
	}
	

}
