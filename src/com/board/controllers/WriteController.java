package com.board.controllers;

import java.util.Scanner;
import com.board.entity.BoardService;
import com.board.front.ActivateControllerInterface;

public class WriteController implements ActivateControllerInterface{
	static Scanner sc = new Scanner(System.in);
	
	@Override
	public void execute() {
		
		String title = null;
		String content = null;
		String writer = null;
		
		System.out.print("제목: ");
		title = sc.next();
		sc.nextLine();
		
		while(title == null){
			System.out.println("제목을 입력하세요...");
			System.out.print("제목: ");
			title = sc.next();
			sc.nextLine();
		}
		
		System.out.print("내용: ");
		content = sc.nextLine();
		
		while(content == null){
			System.out.println("내용을 입력하세요...");
			System.out.print("내용: ");
			content = sc.nextLine();
		}
		
		System.out.print("작성자: ");
		writer = sc.nextLine();
		while(writer == null){
			System.out.println("작성자를 입력하세요...");
			System.out.print("작성자: ");
			writer = sc.nextLine();
		}
		
		int result = BoardService.insertBoard(title, content, writer);
		
		if(result > 0) {
			System.out.println("작성 완료!!!");
		}else {
			System.out.println("작성 실패...\n 다시 시도하세요!");
		}
	}
	
	
}
