package com.board.controllers;

import com.board.front.ActivateControllerInterface;
import java.util.ArrayList;
import java.util.List;

public class ListController implements ActivateControllerInterface {

    class Select {
        int id;
        String writer;
        String title;

        Select( int id, String writer, String title) {
            this.writer = writer;
            this.id = id;
            this.title = title;
        }
    }

    // 게시글 목록
    private List<Select> selectList;

    // 생성자에서 게시글 목록 초기화
    public ListController() {
    	selectList = new ArrayList<>();
    	
    }

    @Override
    public void execute() {
        System.out.println("-----작성한 게시글의 목록입니다-----");

        if (selectList.isEmpty()) {
            System.out.println("작성하신 게시글이 없습니다.");
        } else {
            for (Select select : selectList) {
                System.out.println("ID : " + select.id);
                System.out.println("작성자 : " + select.writer);
                System.out.println("제목 : " + select.title);
                System.out.println("-----------------------------");
            }
        }
    }
}
