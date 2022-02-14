package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dev.service.MemberService;

public class MemberDuplicateController implements Controller{
		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String id = request.getParameter("id");
			MemberService service = MemberService.getInstance();
			int result = service.memberDuplicate(id);
			
			if(result == 1) {
				request.setAttribute("duplicate", "ID 중복 됨");
				request.setAttribute("id", id);
				ForwardPage.forward(request, response, "memberInsert.jsp");
			}
			else {
				request.setAttribute("duplicate", "ID 사용 가능");
				request.setAttribute("id", id);
				ForwardPage.forward(request, response, "memberInsert.jsp");
			}
			
			
		}
}
