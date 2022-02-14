package com.dev.dao;

import java.sql.*;
import java.util.*;

import com.dev.controller.ForwardPage;
import com.dev.vo.MemberVO;
public class MemberDAO {
	
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {};
	public static MemberDAO getInstance() {
		return dao;
	}
	int duplicate_result;
	
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott","tiger");
		}
		catch(Exception ex){
			System.out.println("(1)오류 발생 : " + ex);
		}
		
		return conn; 
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}
			catch(Exception ex) {
				System.out.println("(2)오류 발생 : " + ex);
			}
		}
		close(conn,pstmt);
	}
	
	public void close(Connection conn, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			}
			catch(Exception ex) {
				System.out.println("(3)오류 발생 : " + ex);
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			}
			catch(Exception ex) {
				System.out.println("(4)오류 발생 : " + ex);
			}
		}
	}
	
	public void close(Connection conn, Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			}
			catch(Exception ex) {
				System.out.println("(5)오류 발생 : " + ex);
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			}
			catch(Exception ex) {
				System.out.println("(6)오류 발생 : " + ex);
			}
		}
	}
	
	
	public void tableCreate() {
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		try {
			conn = connect();
			stmt = conn.createStatement();
			sql = "create table member(id varchar2(10) primary key, passwd varchar2(10), name varchar2(10), mail varchar2(20) )";
			stmt.executeUpdate(sql);
		}
		catch(Exception ex) {
			System.out.println("(7)오류 발생" + ex);
		}
		finally {
			close(conn,stmt);
		}
	}
	
	
	
	public int memberInsert(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insert_result = 0;
		try {
			if(duplicate_result == 0) {
				conn = connect();
				pstmt = conn.prepareStatement("insert into member values(?,?,?,?)");
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPasswd());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getMail());
				pstmt.executeUpdate();
				insert_result = 1;
				return insert_result;
			}
			else {
				insert_result = 0;
				return insert_result;
			}
		}
		catch(Exception ex){
			System.out.println("(8)오류 발생 " + ex);
		}
		finally {
			close(conn,pstmt);
		}
		return insert_result;
	}
	
	public int MemberDuplicate(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				duplicate_result = 1;
				return duplicate_result;
			}
			else {
				duplicate_result = 0;
				return duplicate_result;
			}
		}
		catch(Exception ex) {
			System.out.println("(8-1)오류 발생" + ex);
		}
		finally {
			close(conn,pstmt,rs);
		}
		return duplicate_result;
	}
	
	public MemberVO memberSearch(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPasswd(rs.getString(2));
				member.setName(rs.getString(3));
				member.setMail(rs.getString(4));
			}
			
		}
		catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}
		finally {
			close(conn,pstmt,rs);
		}
		
		return member;
	}
	
	
	
	public void memberUpdate(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update member set passwd=?, name=?, mail=? where id=?");
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getMail());
			pstmt.setString(4, member.getId());
			pstmt.executeUpdate();
		}
		catch(Exception ex) {
			System.out.println("(9)오류 발생" + ex);
		}
		finally {
			close(conn,pstmt);
		}
	}
	
	public MemberVO memberDelete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		MemberVO member = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from member where id=?");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}
		catch(Exception ex) {
			System.out.println("(10)오류 발생" + ex);
		}
		finally {
			close(conn,pstmt);
		}
		
		return member;
	}
	
	public ArrayList<MemberVO> memberList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO member = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			while(rs.next()) { //각 행을 기준으로 접근
				member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPasswd(rs.getString(2));
				member.setName(rs.getString(3));
				member.setMail(rs.getString(4));
				list.add(member);
			}
		}
		catch(Exception ex) {
			System.out.println("오류 발생 : " + ex);
		}
		finally {
			close(conn,pstmt,rs);
		}
		
		return list;
	}
	
	public int memberLogin(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = connect();
			pstmt= conn.prepareStatement("select passwd from member where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(passwd)) {
					result = 1;
				}
				else {
					result = 0;
				}
			}
		}
	
		catch(Exception ex) {
			System.out.println("오류 발생 = " + ex);
		}
		
		return result;
	}
	
}
