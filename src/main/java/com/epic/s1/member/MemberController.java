package com.epic.s1.member;

import javax.servlet.http.HttpServletRequest;

public class MemberController {

	public void start(HttpServletRequest request) {
		System.out.println("MemberController ����");
		
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");
		
		String path = uri.substring(index+1);
		
		//member/memberLogin.do
		//memberJoin.do
		//memberPage.do
		
		if(path.equals("memberLogin.do")) {
			System.out.println("�α��� ����");
			
			String value = request.getParameter("id");
			System.out.println(value);
			
			String pw = request.getParameter("pw");
			System.out.println(pw);
			
		} else if (path.equals("memberJoin.do")) {
			System.out.println("ȸ������ ����");
		} else if(path.equals("memberPage.do")) {
			System.out.println("����������");
		} else {
			System.out.println("�� �� ������");
		}
	}
	
}
