package com.dev.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberLoginController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		if(id.isEmpty() || passwd.isEmpty()) {
			request.setAttribute("error", "ID �Ǵ� �н����� �Է¹ٶ�");
			ForwardPage.forward(request, response, "memberLogin.jsp");
		}
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPasswd(passwd);
		
		MemberService service = MemberService.getInstance();
		int result = service.memberLogin(id, passwd);
		
		if(result == 1) {
			request.setAttribute("id", id);
			ForwardPage.forward(request, response, "index.jsp");
		}
		else if(result == 0) {
			request.setAttribute("error", "ID �Ǵ� ��й�ȣ�� Ʋ���ϴ�.");
			ForwardPage.forward(request, response, "memberLogin.jsp");
		}
	}
		
}
