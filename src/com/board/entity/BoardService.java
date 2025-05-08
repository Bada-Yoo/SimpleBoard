package com.board.entity;

public class BoardService {
	BoardDAO boardDAO = new BoardDAO();
	
	public static int insertBoard(String title, String content, String writer) {
		return BoardDAO.insertBoard(title, content, writer);
	}
}
