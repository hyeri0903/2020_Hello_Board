package com.my.spring.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.my.spring.board.vo.BoardVO;


@Repository("boardD")
public class BoardDAOImpl implements BoardDAO {

	@Resource(name = "sqlSession")
	private SqlSession session;
	
	private static String BOARD_PREFIX = "com.my.spring.board";
	
	// 게시물 목록
	@Override
	public List<BoardVO> list() throws Exception {
		System.out.println("BoardDAO execute");
		System.out.println("board dao conn: " + session);
		
		List<BoardVO> result = session.selectList( BOARD_PREFIX +".list") ;
		System.out.println("board dao result : " + result);
		
		return result;
	}

	// 게시물 작성
	@Override
	public void write(BoardVO vo) {
		System.out.println("board dao write execute");
		session.insert(BOARD_PREFIX + ".write", vo);
		
	}

	@Override
	public BoardVO view(int bno) {
		System.out.println("board dao view execute");
		return session.selectOne(BOARD_PREFIX + ".view", bno);
	}

	@Override
	public void modify(BoardVO vo) {
		System.out.println("board dao modify execute");
		session.update(BOARD_PREFIX + ".modify", vo);
		
	}

	@Override
	public void delete(int bno) {
		System.out.println("board dao delete execute");
		session.delete(BOARD_PREFIX + ".delete", bno);
		
	}
	//게시물 총 갯수
	@Override
	public int count() {
		System.out.println("board dao count execute");
		return session.selectOne(BOARD_PREFIX + ".count");
	}

	@Override
	public List listPage(int displayPost, int postNum) {
		HashMap data = new HashMap();
		  
	 data.put("displayPost", displayPost);
	 data.put("postNum", postNum);
	  
	 return session.selectList(BOARD_PREFIX + ".listPage", data);
	}
	
}
