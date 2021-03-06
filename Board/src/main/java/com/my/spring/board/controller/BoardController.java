package com.my.spring.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.spring.board.service.BoardService;
import com.my.spring.board.vo.BoardVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	private BoardService service;
	
	//게시물 목록
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public void getList(Model model) throws Exception {
		System.out.println("BoardCtrl getList execute");
		List<BoardVO> list = null;
		list = service.list();
		
		model.addAttribute("list", list);
	}
	
	//게시물 작성
	@RequestMapping("/write")
	public void getWrite() {
		
	}
	
	@RequestMapping(value = "/write", method=RequestMethod.POST)
	public String postWrite(BoardVO vo) {
		System.out.println("BoardCtrl postWrite execute : " + vo);
		service.write(vo);
		
		return "redirect:/board/list"; // 모든 작업을 마치고 list 페이지로 이동
	}
	
	//게시물 조회
	@RequestMapping("/view")
	//RequestParam : 주소에 있는 특정 값 가져옴, 주소에서 bno를 찾아 int bno에 넣어줌
	public void getView(@RequestParam("bno") int bno, Model model) {
		System.out.println("BoardCtrl getView execute");
		
		BoardVO vo = service.view(bno);
		model.addAttribute("view", vo);
	}
	
	@RequestMapping("/modify")
	public void getModify(@RequestParam("bno") int bno, Model model) {
		System.out.println("BoardCtrl getModify execute");
		BoardVO vo = service.view(bno);
		
		model.addAttribute("view", vo);
	}
	
	//게시물 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postModify(BoardVO vo) {
		service.modify(vo);
		return "redirect:/board/view?bno=" + vo.getBno();
	}
	
	//게시물 삭제
	@RequestMapping("/delete")
	public String getDelete(@RequestParam("bno") int bno){
		service.delete(bno);
		return "redirect:/board/list";
	}
	
	//게시물 목록 + 페이징 추가
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void getListPage(Model model, @RequestParam("num") int num) throws Exception {
		//게시물 총 갯수
		int count = service.count();
		
		//한 페이지에 출력할 게시물 갯수
		int postNum = 10;
		
		//하단 페이징 번호 ([ 게시물 총 갯수 % 한 페이지에 출력할 갯수] 의 올림)
		int pageNum = (int)Math.ceil((double)count/postNum);
		
		//출력할 게시물
		int displayPost = (num-1) * postNum;
		
		 List list = null; 
		 list = service.listPage(displayPost, postNum);
		 model.addAttribute("list", list);   
		 model.addAttribute("pageNum", pageNum);

	}
}
