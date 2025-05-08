package com.board.front;

import java.util.Scanner;

import com.board.front.ActivateControllerInterface;

public class FrontController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);				
        boolean isStop = false;
        ActivateControllerInterface controller = null;

        while (!isStop) {
        	System.out.println("+------------------------------------------+");
        	System.out.println("|       🌊 게시판에 오신 걸 환영합니다 🌊       |");
        	System.out.println("+------------------------------------------+");
        	System.out.println("   당신이 하고싶은 것을 선택해주세요 👇");
        	System.out.println("   1. 게시글 작성       2. 게시글 목록 조회 ");
        	System.out.println("   3. 게시글 상세 조회/수정/삭제            ");
        	System.out.println("   종료하려면 'end'를 입력하세요.");
        	System.out.print("\n👉 입력: ");

            
            String job = sc.next();
            switch (job) {
                case "1"   -> controller = ControllerFactory.make("write");
                case "2" -> controller = ControllerFactory.make("list");
                case "3"   -> controller = ControllerFactory.make("detail");
                case "end"     -> { isStop = true; continue; }
                default        -> { continue; }
            }
            controller.execute();
        }
        sc.close();
        System.out.println("👋 다음에 또 오세요! 저희 게시판과 함께했던 시간, 잊지 마세요 🌅");
    }
}
