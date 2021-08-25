package com.epic.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.epic.s1.util.DBConnectot;

public class MemberDAO {
	
	private DBConnectot DbConnectot;

	public int memberJoin(MemberDTO memberDTO) throws Exception {
		
		Connection con = DbConnectot.getConnect();
		PreparedStatement ps = null;
		int rs = 0;
		
		String sql = "insert INTO member VALUES(?, ?, ?, ?, ?) ";
		
		
			ps = con.prepareStatement(sql);
			ps.setString(1, memberDTO.getId());
			ps.setString(2, memberDTO.getPw());
			ps.setString(3, memberDTO.getName());
			ps.setString(4, memberDTO.getPhone());
			ps.setString(5, memberDTO.getEmail());
			
			result = ps.executeUpdate();
			
			
		
			DbConnectot.disConnect(ps, con);
		
		
		
		
	}
	
}
