package com.dev.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import com.dev.vo.MemberVO;
import com.dev.service.MemberService;

public class MemberListController implements Controller {

public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	MemberService service = MemberService.getInstance();
	ArrayList<MemberVO> list = service.memberList();
	
	request.setAttribute("list", list);
	ForwardPage.forward(request, response, "/result/memberListOutput.jsp");
	
	
}
}
