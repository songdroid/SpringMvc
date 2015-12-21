package com.netsong7.board.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.netsong7.board.repository.BoardDto;

public class BoardServiceImpl implements BoardService {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List getList() throws SQLException {
		/*
		List list = new ArrayList();
		list.add("aaa");
		list.add("aaa");
		list.add("aaa");
		*/
		String sql = "select * from tblSpringBoard order by b_seq desc";
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		RowMapper rowmap = new RowMapper(){
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				BoardDto dto = new BoardDto();
				dto.setB_content(rs.getString("b_content"));
				dto.setB_hitcount(rs.getInt("b_hitcount"));
				dto.setB_password(rs.getString("b_password"));
				dto.setB_regdate(rs.getString("b_regdate"));
				dto.setB_seq(rs.getInt("b_seq"));
				dto.setB_title(rs.getString("b_title"));
				dto.setB_writer(rs.getString("b_writer"));
				return dto;
			}			
		};
		
		list = jdbcTemplate.query(sql, rowmap);
		return list;
	}

	public BoardDto findBySeq() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void write(BoardDto dto) throws SQLException {
		String sql = "insert into tblSpringBoard(b_title, b_content, b_writer, "
			+ "b_regdate, b_hitcount, b_password) values(?,?,?,now(), 0,?)";

		//jdbcTemplate.update(sql, new WriteParams(dto));
		
		Object[] values = new Object[]{dto.getB_title(), dto.getB_content(),
				dto.getB_writer(), dto.getB_password()};
		
		jdbcTemplate.update(sql, values);
	}
	
	/*
	class WriteParams implements PreparedStatementSetter{
		private BoardDto dto;
		
		public WriteParams(BoardDto dto) {
			this.dto = dto;
		}
		
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setString(1, dto.getB_title());
			pstmt.setString(2, dto.getB_content());
			pstmt.setString(3, dto.getB_writer());
			pstmt.setString(4, dto.getB_password());
		}
	}
	*/
	
	public void update(BoardDto dto) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void delete(int seq) throws SQLException {
		// TODO Auto-generated method stub

	}

}
