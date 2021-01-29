package bank;

import java.sql.*;

public class BankDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void connect() {
		conn = DBcon.DBConnect();
	}
	public void conClose() {
		try {
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public int clientNumber() {
		String sql = "SELECT COUNT(*) FROM BANK";
	
		int cNumber = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cNumber = rs.getInt(1);
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return cNumber;
	}
	public void insertClient(BankDTO client) {
		String sql = "INSERT INTO BANK VALUES(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, client.getClientNumber());
			pstmt.setString(2, client.getcName());
			pstmt.setString(3, client.getAccNumber());
			pstmt.setInt(4, client.getBalance());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("고객등록 성공");
			}else {
				System.out.println("고객등록 실패");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	}
	public void deposit(String accNumber, int balance) {
		String sql = "UPDATE BANK SET BALANCE = BALANCE + ? WHERE ACCNUMBER=?";
			
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, balance);
			pstmt.setNString(2, accNumber);
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("입금 완료");
			}else {
				System.out.println("입금 실패");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	}
	public void deposit(BankDTO client) {
		String sql = "UPDATE BANK SET BALANCE = BALANCE + ? WHERE ACCNUMBER=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, client.getBalance());
			pstmt.setNString(2, client.getAccNumber());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("입금 완료");
			}else {
				System.out.println("입금 실패");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	public void withdraw(String accNumber, int balance) {
		String sql = "UPDATE BANK SET BALANCE = BALANCE - ? WHERE ACCNUMBER=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, balance);
			pstmt.setNString(2, accNumber);
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("출금 완료");
			}else {
				System.out.println("출금 실패");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	public int checkBalance(String accNumber) {
		String sql = "SELECT BALANCE FROM BANK WHERE ACCNUMBER = ?";
		int balance = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1,  accNumber);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				balance = rs.getInt(1);//여기서 1 = 1번 컬럼을 의미
				//balance = rs.getInt("BALANCE");// 위와 같은 의미의 명령문
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return balance;
	}
	public boolean checkAccNumber(String accNumber) {
		String sql = "SELECT ACCNUMBER FROM BANK WHERE ACCNUMBER = ?";
		boolean cAccount = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1,  accNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cAccount = true;
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return cAccount;
	}
	public void transfer(String rAccNumber, int balance, String sAccNumber) {
		withdraw1(sAccNumber, balance);
		deposit1(rAccNumber, balance);
		System.out.println("송금 완료");
		
	}
	public void withdraw1(String accNumber, int balance) {
		String sql = "UPDATE BANK SET BALANCE = BALANCE - ? WHERE ACCNUMBER=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, balance);
			pstmt.setNString(2, accNumber);
			
			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	public void deposit1(String accNumber, int balance) {
		String sql = "UPDATE BANK SET BALANCE = BALANCE + ? WHERE ACCNUMBER=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, balance);
			pstmt.setNString(2, accNumber);
			
			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
