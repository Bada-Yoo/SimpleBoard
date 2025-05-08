package com.board.front;

import com.board.controllers.DetailController;

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
