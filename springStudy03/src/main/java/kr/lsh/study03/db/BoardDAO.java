package kr.lsh.study03.db;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.lsh.study03.mapper.BoardMapper;
import kr.lsh.study03.model.BoardVO;

@Component
public class BoardDAO {
	private JdbcTemplate jt;
	
	@Autowired
	public void setData(DataSource dc) {
		this.jt = new JdbcTemplate(dc);
	}
	
	public int wirteBoard(BoardVO param) {
		String sql = " INSERT INTO board(title, ct, nm) "
				+ " VALUES(?, ?, ?) ";
		int result = jt.update(sql,param.getTitle(), param.getCt(), param.getNm());
		
		return result;
	}
	
	public List<BoardVO> getList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = " SELECT * FROM board";
		BoardMapper bm = new BoardMapper();
		list = jt.query(sql, bm);
		
		return list;
	}
	
	public BoardVO getOne(BoardVO param) {
		BoardVO vo = new BoardVO();
		String sql=" select * from board where pk = ? ";
		BoardMapper bm = new BoardMapper();
		vo = jt.queryForObject(sql,new Object[]{param.getPk()} ,bm);
		return vo;
	}
	
	public int delBoard(BoardVO param) {
		int result = 0;
		String sql = "DELETE FROM board WHERE pk = ? ";
		
		 result = jt.update(sql, param.getPk());
		
		return result;
	}
	
	public int updBoard(BoardVO param) {
		int result = 0;
		String sql = "UPDATE board SET title=?, nm = ?, ct=? where pk = ?";
		
		 result = jt.update(sql, param.getTitle(), param.getNm(), param.getCt(), param.getPk());
		return result;
	}
}
