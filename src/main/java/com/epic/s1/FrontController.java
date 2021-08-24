package com.epic.s1;

import java.io.IOException;
import java.lang.reflect.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epic.s1.bankbook.BankbookController;
import com.epic.s1.member.MemberController;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberController memberController;
	private BankbookController bankbookController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        memberController = new MemberController();
        bankbookController = new BankbookController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Front Controller 실행");
		String uri = request.getRequestURI();
		//String url = request.getRequestURL().toString();
		System.out.println("URI : " + uri);
		//System.out.println("URL : " + url);
		
		String path = "";
		
		int startIndex = request.getContextPath().toString().length();
		int lastIndex = uri.lastIndexOf("/");
		path = uri.substring(startIndex, lastIndex);
		
		if (path.equals("/member")) {
			memberController.start(request);
		} else if(path.equals("/bankbook")) {
			bankbookController.start(request, response);
		} else {
			System.out.println("존재한지 않는 URI");
		}
		
		
		System.out.println("path : " + path);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
