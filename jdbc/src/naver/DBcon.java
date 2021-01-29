package naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {
		public static Connection DBConnect() {
				
				Connection con = null;
				
				String url = "jdbc:oracl:thin@localhost:1521:XE";
				
				String user = "qwerty";
				String password = "1111";
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					con = DriverManager.getConnection(url,user,password);
					
					System.out.println("db접속 성공");
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("db접속 실패: 드라이버 로딩 실패");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("db접속 실패: 계정정보확인");
				}
				return con;
		}
}
