package com.dev.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import com.dev.vo.MemberVO;
import com.dev.service.MemberService;

public class MemberUpdateController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		
		if(passwd.isEmpty() || name.isEmpty() || mail.isEmpty()) {
			request.setAttribute("error", "모든 항목 입력바람");
			ForwardPage.forward(request, response, "memberUpdate.jsp");
		}
		
		MemberVO member = new MemberVO();
		member.setPasswd(passwd);
		member.setName(name);
		member.setMail(mail);
		
		MemberService service = MemberService.getInstance();
		service.memberUpdate(member);
		
		request.setAttribute("name", name);
		ForwardPage.forward(request, response, "/result/memberUpdateOutput.jsp");
	}
	
	
}
