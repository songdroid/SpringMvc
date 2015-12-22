package com.netsong7.board.service;

import java.sql.SQLException;
import java.util.List;
import com.netsong7.board.repository.BoardDto;
import mybatis.BoardManager;

public class BoardServiceImpl implements BoardService {
	public List getList() throws SQLException {
		return BoardManager.getList();
	}
	
	public BoardDto findBySeq(int seq) throws SQLException {
		return BoardManager.findBySeq(seq);
	}

	public void write(BoardDto dto) throws SQLException {
		BoardManager.write(dto);
	}
	
	public void update(BoardDto dto) throws SQLException {
		BoardManager.update(dto);
	}

	public void delete(int seq) throws SQLException {
		BoardManager.delete(seq);
	}
}
