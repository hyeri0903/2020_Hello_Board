package com.sinc.intern.board.model.sql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("boardD")
public class BoardDaoImpl implements BoardDao {
	
	@Resource(name = "sqlSession")
	private SqlSession session ;
	
	public static final String BOARD_PREFIX = "com.sinc.intern.board";
	
	@Override
	public List<Object> listRow() {
		System.out.println("BoardDao execute");
		System.out.println("board dao conn: " + session);
		
		List<Object> result = session.selectList( BOARD_PREFIX +".list") ;
		System.out.println("board dao result : " + result);
		
		return result;
	}

	@Override
	public int registerRow(Object obj) {
		System.out.println("board dao registerRow");
		return session.insert(BOARD_PREFIX +".register", obj);
	}
	
	public int upCnt(Object obj) {
		return session.update(BOARD_PREFIX + ".upCnt", obj) ;
	}

	@Override
	public Object readRow(Object obj) {
		int upCntFlag = upCnt(obj);
		System.out.println("upCntFlag : " + upCntFlag);
		System.out.println("board dao readRow : "+ obj);
		return session.selectOne(BOARD_PREFIX +".read", obj);
	}

	@Override
	public int removeRow(Object obj) {
		System.out.println("board removeRow : " + obj);
		return session.delete(BOARD_PREFIX +".remove", obj);
	}

	@Override
	public int updateRow(Object obj) {
		System.out.println("board updateRow : " + obj);
		return session.update(BOARD_PREFIX +".modify", obj) ;
	}



	@Override
	public List<Object> searchRow(HashMap<String, String> map) {
		System.out.println("board searchRow execute");
		return session.selectList(BOARD_PREFIX +".search", map) ;
	}

	
}
