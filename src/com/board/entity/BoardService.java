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
}
