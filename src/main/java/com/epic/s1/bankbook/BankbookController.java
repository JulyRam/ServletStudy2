package com.epic.s1.bankbook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BankbookController {
	private BankbookDAO bankbookDAO;
	
	public BankbookController() {
		bankbookDAO = new BankbookDAO();
	}

	public void start(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BankBook Controller 실행");
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");
		
		
		String path=uri.substring(index+1);
		
		if(path.equals("bankbookList.do")) {
			//상품 목록(List)
			System.out.println("상품 목록");
			ArrayList<BankbookDTO> ar = bankbookDAO.getList();
			//for(초기식;조건식;증감식)
			//for(모은타입명 변수명:컬렉션참조변수명)
			for(BankbookDTO bankBookDTO:ar) {
				System.out.println(bankBookDTO.getBookName());
			}
			
			request.setAttribute("list", ar);
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookList.jsp");
			try {
				view.forward(request, response);
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(path.equals("bankbookInsert.do")) {
			//상품 등록(Insert)
			System.out.println("상품등록");
			
			String method = request.getMethod();
			System.out.println("Method : " + method);
			
			if (method.equals("POST")) {
			}else if (path.equals("bankbookInsert2.do")) {
				//상품 등록(Insert)2
				System.out.println("insert2");
				
				//파라미터값 출력
				String bookName = request.getParameter("bookName");
				String bookRate = request.getParameter("bookRate");
				String bookSale = request.getParameter("bookSale");
				BankbookDTO bankbookDTO = new BankbookDTO();
				bankbookDTO.setBookName(bookName);
				bankbookDTO.setBookRate(Double.parseDouble(bookRate));
				bankbookDTO.setBookSale(Integer.parseInt(bookSale));
				
				int result = bankbookDAO.setInsert(bankbookDTO);
				System.out.println(result);
				
				/*
				 * ArrayList<BankbookDTO> ar = bankbookDAO.getList();
				 * request.setAttribute("list", ar);
				 */
				
				try {
					response.sendRedirect("./bankbookList.do");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else {
				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookInsert.jsp");
				try {
					view.forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}else if(path.equals("bankbookSelect.do")) {
			//상품 조회(Select)
			System.out.println("상품상세조회");
			String num = request.getParameter("bookNumber");
			long num2 = Long.parseLong(num);
			System.out.println("Num2 : "+num2);
			
			BankbookDTO bankBookDTO = new BankbookDTO();
			bankBookDTO.setBookNumber(num2);
			bankBookDTO = bankbookDAO.getSelect(bankBookDTO);
			System.out.println(bankBookDTO.getBookName());
			
			request.setAttribute("dto", bankBookDTO);
			request.setAttribute("count", 123);
			request.setAttribute("name", "iu");
			
			HttpSession session = request.getSession();
			session.setAttribute("se", "session");
			request.setAttribute("se", "request");
			
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookSelect.jsp");
			try {
				view.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else {
			System.out.println("그 외 나머지");
		}
	}

}