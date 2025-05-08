package com.board.entity;


import com.board.front.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardDAO {
    // selectDetail
    public BoardDTO selectDetail(int id) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "select * from simpleboard where id = ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if(rs.next()) {
                BoardDTO board = makeBoard(rs);
                return board;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, pst, rs);
        }

        return null;
    }

    private BoardDTO makeBoard(ResultSet rs) throws SQLException {
        BoardDTO board = BoardDTO.builder()
                .id(rs.getInt("id"))
                .title(rs.getString("title"))
                .content(rs.getString("content"))
                .writer(rs.getString("writer"))
                .createdDate(rs.getTimestamp("createdDate"))
                .build();

        return board;
    }

    // update
    public int updateBoard(BoardDTO board) {
        int result = 0;
        Connection conn = DBUtil.getConnection();
        PreparedStatement pst = null;

        Map<String, Object> dynamicSQL = new HashMap<>();

        if(board.getTitle() != null) dynamicSQL.put("title", board.getTitle());
        if(board.getContent() != null) dynamicSQL.put("content", board.getContent());
        if(board.getWriter() != null) dynamicSQL.put("writer", board.getWriter());
        if(board.getCreatedDate() != null) dynamicSQL.put("createdDate", board.getCreatedDate());

        String sql = "update simpleboard set ";
        String sql2 = " where id = ?";
        for(String key : dynamicSQL.keySet()) {
            sql += key + " = ?, ";
        }
        sql = sql.substring(0, sql.length() - 2);
        sql += sql2;

        try {
            pst = conn.prepareStatement(sql);
            int i = 1;
            for(String key : dynamicSQL.keySet()) {
                pst.setObject(i++, dynamicSQL.get(key));
            }
            pst.setInt(i, board.getId());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, pst, null);
        }

        return result;
    }

    // delete
    public int deleteById(int id) {
        int result = 0;
        Connection conn = DBUtil.getConnection();
        PreparedStatement pst = null;
        String sql = "delete from simpleboard where id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, pst, null);
        }

        return result;
    }
    
    //insert
  	public static int insertBoard(String title, String content, String writer) {
  		int result = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		String sql = """
				insert into simpleboard(
					ID,
					TITLE,
					CONTENT,
					WRITER,
					CREATEDDATE
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
  	
  	//select
  	public List<BoardDTO> selectBoard() {
  		List<BoardDTO> boardList = new ArrayList<>();
  	    	
  	        Connection conn = DBUtil.getConnection();
  	        Statement st = null;
  	        ResultSet rs = null;
  	      String sql = """
  	    	    SELECT * FROM SimpleBoard
  	    	    ORDER BY id ASC
  	    	""";

  	        try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()) {
					BoardDTO board = makeBoard(rs);
					boardList.add(board);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
  	        return boardList;
  	       
  	}
  	

}