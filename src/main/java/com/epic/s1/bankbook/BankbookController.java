package com.epic.s1.bankbook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BankbookController {
	private BankbookDAO bankbookDAO;
	
	public BankbookController() {
		bankbookDAO = new BankbookDAO();
	}

	public void start (HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Bankbook Controller 실행");
		
		String uri = request.getRequestURI("../WEB-INF/views/bankbook/bankbookSelect.jsp");
		int index = uri.lastIndexOf("/");
		
		String path = uri.substring(index+1);
		
		//bankbookList.do
		//bankbookInsert.do
		//bankbookSelect.do
		
		
		if(path.equals("bankbookList.do")) {
			System.out.println("상품목록");
			bankbookDAO.getList();
			ArrayList<BankbookDTO> ar = bankbookDAO.getList();
			
			//for(모은타입명 변수명:컬렉션참조변수명)
			for (BankbookDTO bankbookDTO:ar) {
				System.out.println(bankbookDTO.getBookName());
			}
			
		} else if (path.equals("bankbookInsert.do")) {
			System.out.println("상품등록");
		} else if(path.equals("bankbookSelect.do")) {
			System.out.println("상품상세조회");
			
			String number = request.getParameter("bookNumber");
			System.out.println(number);
			int num2 = Integer.parseInt(number);
			
			BankbookDTO bankbookDTO = new BankbookDTO();
			bankbookDTO.setBookNumber(num2);
			bankbookDTO = bankbookDAO.getSelect(bankbookDTO);
			System.out.println(bankbookDTO.getBookName());
			
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookSelect.jsp");
			try {
				view.forward(request, response);
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		} else {
			System.out.println("그 외 나머지");
		}
	}
	
}
