package kr.lsh.study03.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.lsh.study03.model.BoardVO;

public class BoardMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO vo =new BoardVO();
		vo.setPk(rs.getInt("pk"));
		vo.setTitle(rs.getString("title"));
		vo.setNm(rs.getString("nm"));
		vo.setCt(rs.getString("ct"));
		return vo;
		
	}

}
