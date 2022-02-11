package com.dev.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberSearchController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		String job = request.getParameter("job");
		String path = null;
		
		if(job.equals("search"))
			path = "memberSearch.jsp";
		if(job.equals("update"))
			path = "memberUpdate.jsp";
		if(job.equals("delete"))
			path = "memberDelete.jsp";
		
		if(id.isEmpty()) {
			request.setAttribute("error", "ID입력 바람");
			ForwardPage.forward(request, response, path);
		}

		
		MemberService service = MemberService.getInstance();
		MemberVO member = service.memberSearch(id);
		
		if(member == null) {
			request.setAttribute("result", "검색 값이 존재하지 않음");
			request.setAttribute("error", "검색 값이 존재하지 않음 ");
		}
		else {
			request.setAttribute("member", member);
		}
		
		request.setAttribute("id", id); //id값을 job에 해당하는 path로 던져줌 (컨트롤러 끼리 요청정보 공유 불가하므로 이렇게)
		if(path.equals("memberSearch.jsp")) {
			ForwardPage.forward(request, response, "/result/memberSearchOutput.jsp");
		}
		else {
			ForwardPage.forward(request, response, path);
		}
		
		
	}
}
