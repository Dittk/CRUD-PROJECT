package com.dev.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLogoutController implements Controller{
	
	@Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("id","");
		PrintWriter out = response.getWriter();
		out.println("<script language='javascript'>'");
				out.println("alert('¾Ë¸²Ã¢')");
				out.println("</script>");
				response.sendRedirect("index.jsp");
	
}
}
