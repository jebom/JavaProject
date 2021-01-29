package jdbc0120;
import java.sql.*;

public class stuSQL {
	
	Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs;
	
	public void connect() {
		con = DMBcon.DBConnect();
	}
	public void conClose() {
		try {
			con.close();
			System.out.println("DB접속해제");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void insert(StuDTO stu) {
		String sql = "INSERT INTO STUDTO VALUES(?,?)";
		
		System.out.println("학생정보 : "+stu);
		System.out.println("DB연결 : "+con);
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setNString(1, stu.getStuName());
			pstmt.setInt(2, stu.getStuAge());
			
			int count = pstmt.executeUpdate();
			if (count>0) {
				System.out.println("학생등록 성공");
			}else {
				System.out.println("학생등록 실패");
			}
		}catch (SQLException se){
			se.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
		}
	}
	public void select() {
		String sql = "SELECT * FROM NAVER";
		int i =1;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {	// 조회된 데이터의 갯수만큼 반복문 실행
					// Cardinality(Tuple, Record, 데이터의 수)
				System.out.println(i+"번째 학생 정보");
				System.out.println("이름 : " + rs.getString(1));
				System.out.println("나이 : " + rs.getInt(2));
				System.out.println();
				i++;
			}
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}

	}
	public void update(StuDTO stu) {
		String sql = "UPDATE STUDTO SET STUAGE=? WHERE STUNAME=?";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, stu.getStuAge());
			pstmt.setNString(2, stu.getStuName());
			
			
			int count = pstmt.executeUpdate();
			if (count>0) {
				System.out.println("학생정보 수정 성공");
			}else {
				System.out.println("학생정보 수정 실패");
			}
		}catch (SQLException se){
			se.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
		}
	}
	public void delete(String delName) {
		String sql = "DELETE STUDTO WHERE STUNAME=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, delName);
			
			int count = pstmt.executeUpdate();
			if (count>0) {
				System.out.println("학생정보 삭제 성공");
			}else {
				System.out.println("학생정보 삭제 실패");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
		}
	}
}
