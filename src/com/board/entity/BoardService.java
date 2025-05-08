package com.board.entity;

public class BoardService {
    BoardDAO boardDAO = new BoardDAO();

    public BoardDTO selectDetail(int id) {
        return boardDAO.selectDetail(id);
    }

    public int update(BoardDTO board) {
        return boardDAO.update(board);
    }

    public int delete(int id) {
        return boardDAO.deleteById(id);
    }
  	public static int insertBoard(String title, String content, String writer) {
	  	return BoardDAO.insertBoard(title, content, writer);
	}

}
