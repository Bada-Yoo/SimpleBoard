package com.board.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.board.front.DBUtil;

public class BoardDAO {
	
	//insert
	public static int insertBoard(String title, String content, String writer) {
		int result = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		String sql = """
				insert into cart(
					ID,
					TITLE,
					CONTENT,
					WRITER,
					CREATEDDATE,
				)values(board_seq.nextval,?,?,?,sysdate)
				""";
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, content);
			st.setString(3, writer);
			result = st.executeUpdate();
		} catch (SQLException e) {
			
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
		return result;
	}
	
	//make
	private BoardDTO makeBoard(ResultSet rs) throws SQLException {
		BoardDTO board = BoardDTO.builder()
				.id(rs.getInt("ID"))
				.title(rs.getString("TITLE"))
				.content(rs.getString("CONTENT"))
				.writer(rs.getString("WRITER"))
				.createdDate(rs.getTimestamp("CREATEDDATE"))
				.build();
		return board;
	}
}
