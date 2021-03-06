package com.my.spring.board.dao;

import java.util.List;

import com.my.spring.board.vo.BoardVO;

public interface BoardDAO {

	public List<BoardVO> list() throws Exception; 	//게시물 목록
	public void write(BoardVO vo); 	//게시물 작성
	public BoardVO view(int bno); 	// 게시물 조회
	public void modify(BoardVO vo); //게시물 수정
	public void delete(int bno); //게시물 삭제
	public int count(); // 게시물 총 갯수
	public List listPage(int displayPost, int postNum); //게시물 목록 + 페이징
}
