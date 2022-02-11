package com.dev.controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.ServletConfig;

public class FrontController extends HttpServlet {
		private static final long serialVersionUID = 1L;
		String charset = null;
		HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig sc) throws ServletException{
		charset = sc.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		list.put("/memberInsert.do", new MemberInsertController());
		list.put("/memberSearch.do", new MemberSearchController());
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/memberList.do", new MemberListController());
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(charset);
		String url = request.getRequestURI();
		String contextpath = request.getContextPath();
		String path = url.substring(contextpath.length());
		Controller subController = list.get(path);
		subController.execute(request, response);
	}
	
}
