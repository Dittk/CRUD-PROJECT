package com.dev.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberInsertController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		
		if(id.isEmpty() || passwd.isEmpty() || name.isEmpty() || mail.isEmpty()) {
			request.setAttribute("error", "��� �׸� �Է¹ٶ�");
			ForwardPage.forward(request, response, "/memberInsert.jsp");
			return;
		}
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setMail(mail);
		
		MemberService service = MemberService.getInstance();
		//service.tableCreate();
		service.memberInsert(member);
		
		request.setAttribute("member", member);
		ForwardPage.forward(request, response, "/result/memberInsertOutput.jsp");
	}
}
