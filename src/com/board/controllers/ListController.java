package com.board.controllers;

import com.board.entity.BoardDAO;
import com.board.entity.BoardDTO;
import com.board.entity.BoardService;
import com.board.front.ActivateControllerInterface;
import java.util.ArrayList;
import java.util.List;

public class ListController implements ActivateControllerInterface {
	BoardService boardService = new BoardService();

    @Override
    public void execute() {
    	List<BoardDTO> selectList = boardService.selectBoard();
        System.out.println("-----작성한 게시글의 목록입니다-----");

        if (selectList.isEmpty()) {
            System.out.println("작성하신 게시글이 없습니다.");
        } else {
            for (BoardDTO select : selectList) {
                System.out.println("ID : " + select.getId());
                System.out.println("작성자 : " + select.getWriter());
                System.out.println("제목 : " + select.getTitle());
                System.out.println("-----------------------------");
            }
        }
    }
}

