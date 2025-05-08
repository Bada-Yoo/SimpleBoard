package com.board.entity;

import java.util.List;

public class BoardService {
    BoardDAO boardDAO = new BoardDAO();

    public BoardDTO selectDetail(int id) {
        return boardDAO.selectDetail(id);
    }

    public int updateBoard(BoardDTO board) {
        return boardDAO.updateBoard(board);
    }

    public int deleteBoard(int id) {
        return boardDAO.deleteById(id);
    }
  	public static int insertBoard(String title, String content, String writer) {
	  	return BoardDAO.insertBoard(title, content, writer);
	}
  	
  	public List<BoardDTO> selectBoard() {
	  	return boardDAO.selectBoard();
  	}

}
