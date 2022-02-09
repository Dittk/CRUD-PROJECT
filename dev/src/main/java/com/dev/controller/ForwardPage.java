package com.dev.controller;

import javax.servlet.*;
import javax.servlet.http.*;
public class ForwardPage {
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) {
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
		catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}
	}
	
}
