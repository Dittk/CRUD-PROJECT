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

	public int memberInsert(MemberVO member) {
		int result = dao.memberInsert(member);
		return result;
	}
	
	public int memberDuplicate(String id) {
		int result = dao.MemberDuplicate(id);
		return result;
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
	
	public int memberLogin(String id, String passwd) {
		int result = dao.memberLogin(id, passwd);
		return result;
	}
	
}
