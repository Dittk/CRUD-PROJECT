package com.dev.service;

import com.dev.vo.MemberVO;
import com.dev.dao.MemberDAO;


public class MemberService {
	
	private static MemberService service = new MemberService();
	MemberDAO dao = MemberDAO.getInstance();
	private MemberService() {};
	MemberVO member = null;
	public static MemberService getInstance() {
		return service;
	}
	
	public void tableCreate() {
		dao.tableCreate();
	}

	public void memberInsert(MemberVO member) {
		dao.memberInsert(member);
	}
	
	public MemberVO memberSearch(String id) {
		MemberVO member = dao.memberSearch(id);
		return member;
	}
}
