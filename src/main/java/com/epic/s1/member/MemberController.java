package com.epic.s1.member;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController {
	
	private MemberService memberService;
	
	public MemberController() {
		memberService = new MemberService();
	}
	
	public void start(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberController ����");
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");
		
		
		String path=uri.substring(index+1);
		
		if(path.equals("memberLogin.do")) {
			System.out.println("�α��� ����");
			String value= request.getParameter("id");
			System.out.println(value);
			String pw = request.getParameter("pw");
			System.out.println(pw);
		}else if(path.equals("memberJoin.do")) {
			
			String method = request.getMethod();
			
			if(method.equals("POST")) {
				int result = memberService.memberJoin(request, response);
				if(result>0) {
					response.sendRedirect("../");
				}else {
					response.sendRedirect("./memberJoin.do");
				}
				
			}else {
				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/member/memberJoin.jsp");
				view.forward(request, response);
			}
			
			
			
		}else if(path.equals("memberPage.do")) {
			System.out.println("myPage ����");
		}else {
			System.out.println("�� �� ������");
		}
		
	}

}