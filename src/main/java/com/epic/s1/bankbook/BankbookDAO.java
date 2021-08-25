package com.epic.s1.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.epic.s1.util.DBConnectot;
import com.sun.net.httpserver.Authenticator.Result;

public class BankbookDAO {

	private DBConnectot dbConnectot;
	
	public BankbookDTO getSelect(BankbookDTO bankbookDTO) {
		
		dbConnectot = new DBConnectot();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BankbookDTO result = null;
		
		con = dbConnectot.getConnect();
		String sql = "SELECT * FROM BANKBOOK WHERE BANKNUMBER = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, bankbookDTO.getBookNumber());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = new BankbookDTO();
				result.setBookNumber(rs.getLong("bookNumber"));
				result.setBookName(rs.getString("bookName"));
				result.setBookRate(rs.getDouble("bookRate"));
				result.setBookSale(rs.getInt("bookSale"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			dbConnectot.disConnect(rs, ps, con);
		}
		
		return result;
	}
	
	public ArrayList<BankbookDTO> getList() {
		
		dbConnectot = new DBConnectot();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BankbookDTO> ar = new ArrayList<BankbookDTO>();
		
		con = dbConnectot.getConnect();
		String sql = "SELECT bankbookList FROM BANKBOOK";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				BankbookDTO bankbookDTO = new BankbookDTO();
				bankbookDTO.setBookNumber(rs.getLong("bookNumber"));
				bankbookDTO.setBookName(rs.getString("bookName"));
				bankbookDTO.setBookRate(rs.getDouble("bookRate"));
				bankbookDTO.setBookSale(rs.getInt("bookSale"));
				ar.add(bankbookDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbConnectot.disConnect(rs, ps, con);
		}
	return ar;	
	}
	
	public int setInsert(BankbookDTO bankbookDTO) {
		

		Connection con = dbConnectot.getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		
		
		String sql = "Insert into bankbook (bookNumber, bookName, bookRate, bookSale "
				+ "values (bankbook_seq.nextval, ?, ?, ?)";
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, bankbookDTO.getBookName());
			ps.setDouble(2, bankbookDTO.getBookRate());
			ps.setInt(3, bankbookDTO.getBookSale());
			
			rs = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resul;
	}
}
