package com.sinc.intern.board.service;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
	public List<Object> list();
	public int 			register(Object obj) ;
	public Object		view(Object obj);
	public int			remove(Object obj);
	public int			update(Object obj);
	public List<Object> search(HashMap<String, String> map);
}
