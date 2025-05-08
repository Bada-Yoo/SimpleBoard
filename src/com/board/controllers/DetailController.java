package com.board.controllers;

import com.board.entity.BoardDTO;
import com.board.entity.BoardService;
import com.board.front.ActivateControllerInterface;

import java.util.Scanner;

public class DetailController implements ActivateControllerInterface {
    Scanner sc = new Scanner(System.in);
    BoardService boardService = new BoardService();

    @Override
    public void execute() {
        boolean isStop = false;
        while (!isStop) {
            System.out.println("+------------------------------------------+");
            System.out.println("|           🌊 게시판 상세 기능 🌊           |");
            System.out.println("+------------------------------------------+");
            System.out.println("   당신이 하고싶은 것을 선택해주세요 👇");
            System.out.println("   1. 게시글 상세조회       2. 게시글 수정 ");
            System.out.println("   3. 게시글 삭제");
            System.out.println("   종료하려면 'end'를 입력하세요.");
            System.out.print("\n👉 입력: ");


            String job = sc.next();
            switch (job) {
                case "1" -> f_detatil();
                case "2" -> f_update();
                case "3" -> f_delete();
                case "end"     -> { isStop = true; continue; }
                default        -> { continue; }
            }
        }
    }

    private void f_delete() {
        System.out.print("삭제할 게시글의 ID를 입력하세요: ");
        int id = sc.nextInt();
        sc.nextLine();

        BoardDTO board = boardService.selectDetail(id);
        if(board == null) {
            System.out.println("해당 게시글이 존재하지 않습니다.");
            return;
        }

        int result = boardService.deleteBoard(id);
        System.out.println(result + "개의 게시글이 삭제되었습니다.");
    }

    private void f_update() {
        System.out.print("수정할 게시글의 ID를 입력하세요: ");
        int id = sc.nextInt();
        sc.nextLine();

        BoardDTO board = boardService.selectDetail(id);
        if(board == null) {
            System.out.println("해당 게시글이 존재하지 않습니다.");
            return;
        }

        int result = boardService.updateBoard(makeBoard(id));
        System.out.println(result + "개의 게시글이 수정되었습니다.");
    }

    private BoardDTO makeBoard(int id) {
        System.out.print("수정할 제목을 입력하세요: ");
        String title = sc.nextLine();
        System.out.print("수정할 내용을 입력하세요: ");
        String content = sc.nextLine();
        System.out.print("수정할 작성자를 입력하세요: ");
        String writer = sc.nextLine();

        if(title.equals("0")) title = null;
        if(content.equals("0")) content = null;
        if(writer.equals("0")) writer = null;

        BoardDTO board = BoardDTO.builder()
                .id(id)
                .title(title)
                .content(content)
                .writer(writer)
                .build();

        return board;
    }

    private void f_detatil() {
        System.out.print("상세조회할 게시글의 ID를 입력하세요: ");
        int id = sc.nextInt();
        sc.nextLine();

        BoardDTO board = boardService.selectDetail(id);
        if(board == null) {
            System.out.println("해당 게시글이 존재하지 않습니다.");
            return;
        }

        System.out.printf("게시글 %d 제목 [%s] 작성자: %s\n", board.getId(), board.getTitle(), board.getWriter());
        System.out.println(board.getContent());
        System.out.printf("작성일: %s\n", board.getCreatedDate());
    }
}
