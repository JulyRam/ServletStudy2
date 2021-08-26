package com.epic.s1.test;

import java.sql.Connection;

import com.epic.s1.bankbook.BankbookDAO;
import com.epic.s1.bankbook.BankbookDTO;
import com.epic.s1.util.DBConnector;

public class DBTest {

	public static void main(String[] args) {
		
		//Test
		/*
		DBConnectot dbConnectot = new DBConnectot();
		Connection con = dbConnectot.getConnect();
		System.out.println(con);
		*/
		
		//BankbookDAO getSelect Test
		BankbookDAO bankbookDAO = new BankbookDAO();
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBookNumber(1000);
		bankbookDTO = bankbookDAO.getSelect(bankbookDTO);
		
		System.out.println(bankbookDTO.getBookName());
	}

}
