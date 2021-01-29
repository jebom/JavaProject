package naver;

import java.sql.*;

public class NaverDAO {
	//DAO (data access object 데이터접근 객체)
	Connection conn = null;
	//Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void connect() {
		conn = DBcon.DBConnect();//conn에 DBcon클래스 의 DBconnect메소드 의 리턴 con값을 받아 DB접속
	}
	
	public void conClose() {
		try {
			conn.close();//connection 클래스의 내장메소드 -DB접속해제
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public void memberJoin(NaverDTO naver) {
		String sql = "INSERT INTO NAVER VALUES(?,?,?,?,?,?,?)";
		
		System.out.println("회원정보 : "+naver);
		System.out.println("DB연결 : "+conn);
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setNString(1, naver.getnID());
			pstmt.setNString(2, naver.getnPW());
			pstmt.setNString(3, naver.getnName());
			pstmt.setNString(4, naver.getnBirth());
			pstmt.setNString(5, naver.getnGender());
			pstmt.setNString(6, naver.getnEmail());
			pstmt.setNString(7, naver.getnPhone());
			
			/* 여기서 integer result1,boolean result2는 실행결과 성공여부를 확인하기 위해서 
			int result1 = pstmt.executeUpdate();
			if (result1>0) {
				System.out.println("회원등록 성공");
			}else {
				System.out.println("회원등록 실패");
			}
			*/
			boolean result2 = pstmt.execute();//실행됐을때 false값 출력
			if (!result2) {
				System.out.println("회원등록 성공");
			}else {
				System.out.println("회원등록 실패");
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

	public void memberList() {
		String sql = "SELECT * FROM NAVER";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // SQL실행명령 문
			//execute() => boolean 타입반환
			//executeQuery() => integer 타입반환
			//executeUpdate() => ResultSet 타입반환
			int i=0;
			while(rs.next()) {	// 조회된 데이터의 갯수만큼 반복문 실행
				// Cardinality(Tuple, Record, 데이터의 수)
				System.out.println(i+"번째 회원 정보");
				System.out.println("아이디 : " + rs.getString(1));
				System.out.println("비밀번호 : " + rs.getString(2));
				System.out.println("이름 : " + rs.getString(3));
				System.out.println("생년월일 : " + rs.getString(4));
				System.out.println("성별 : " + rs.getString(5));
				System.out.println("이메일 : " + rs.getString(6));
				System.out.println("전화번호 : " + rs.getString(7));
				System.out.println();
				i++;
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

	public void memberModify(NaverDTO naver) {
		String sql = "UPDATE NAVER SET NPW=?, NNAME=?, NBIRTH=?, NGENDER=?, NEMAIL=?, NPHONE=? WHERE NID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setNString(1, naver.getnPW());
			pstmt.setNString(2, naver.getnName());
			pstmt.setNString(3, naver.getnBirth());
			pstmt.setNString(4, naver.getnGender());
			pstmt.setNString(5, naver.getnEmail());
			pstmt.setNString(6, naver.getnPhone());
			pstmt.setNString(7, naver.getnID());
			
			int result1 = pstmt.executeUpdate();
			if (result1>0) {
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

	public void memberDelete(String delId) {
		String sql = "DELETE NAVER WHERE NID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setNString(1, delId);
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("삭제성공");
			}else {
				System.out.println("삭제실패");
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

	public boolean idCheck(String delId, String delPW) {
		String sql = "SELECT NID FROM NAVER WHERE NID=? AND NPW=?";
		boolean checkResult = false;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setNString(1, delId);
			pstmt.setNString(2, delPW);
			
			rs = pstmt.executeQuery();// rs의 값은 한개 이므로 while아니고 if문
			
			if(rs.next()) {
				checkResult = true;
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
		
		return checkResult;
	}
}
