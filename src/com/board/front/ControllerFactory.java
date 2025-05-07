package com.board.front;

import com.board.front.ActivateControllerInterface;

public class ControllerFactory {

	public static ActivateControllerInterface make(String business) {
		ActivateControllerInterface controller = null;
		
		switch (business) {
		  case "write"->{controller = new WriteController();}  
		  case "list"->{controller = new ListController();}
		  case "detail"->{controller = new DetailController();}
		}
		
		
		return controller;
	}


}
