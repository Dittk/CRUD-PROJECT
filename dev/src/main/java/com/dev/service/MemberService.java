package com.dev.service;

import com.dev.vo.MemberVO;
import com.dev.dao.MemberDAO;
import java.util.*;

public class MemberService {
	
	private static MemberService service = new MemberService();
	MemberDAO dao = MemberDAO.getInstance();
	private MemberService() {};
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
	
	public void memberUpdate(MemberVO member) {
		dao.memberUpdate(member);
	}
	
	public MemberVO memberDelete(String id) {
		MemberVO member = dao.memberDelete(id);
		return member;
	}
		
	public ArrayList<MemberVO> memberList() {
		ArrayList<MemberVO> list = dao.memberList();
		return list;
	}
	
	
}
