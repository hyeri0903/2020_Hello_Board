package com.sinc.intern.board.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.intern.board.model.sql.BoardDao;


@Service("boardS")

public class BoardServiceImpl implements BoardService {
	@Resource(name = "boardD")
	private BoardDao dao ;
	
	@Override
	public List<Object> list() {
		System.out.println("BoardServiceImpl execute");
		return dao.listRow();
	}

	@Override
	public int register(Object obj) {
		System.out.println("BoardService  register: " + obj );
		return dao.registerRow(obj);
	}

	@Override
	public Object view(Object obj) {
		System.out.println("BoardService view");
		return dao.readRow(obj);
	}

	@Override
	public int remove(Object obj) {
		System.out.println("BoardService remove");
		return dao.removeRow(obj);
	}

	@Override
	public int update(Object obj) {
		System.out.println("BoardService modify");
		return dao.updateRow(obj);
	}

	@Override
	public List<Object> search(HashMap<String, String> map) {
		System.out.println("BoardService search");
		return dao.searchRow(map);
	}

	
}
