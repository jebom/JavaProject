package naver;

import java.util.Scanner;

public class NaverMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean op = true;
		NaverDTO naver = new NaverDTO();
		NaverDAO server = new NaverDAO();
		Scanner sc = new Scanner(System.in);
		while(op) {
			System.out.println("===============================");
			System.out.println("1.DB접속 2.DB해제 3.회원등록  4.회원조회");
			System.out.println("5.회원수정 6.회원삭제 7.종료");
			System.out.println("===============================");
			System.out.print("메뉴를 선택 하시오 >> ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1: server.connect();
					break;
			case 2: server.conClose();
					break;
			case 3: System.out.println("회원정보 입력");
					System.out.print("아이디 >>");
					String nId = sc.next();
					naver.setnID(nId);
					System.out.print("비밀번호 >>");
					String nPw = sc.next();
					System.out.print("비밀번호 확인 >>");
					String nPwc = sc.next();
					if(nPw.equals(nPwc)) {
						System.out.println("Correct PW");
						naver.setnPW(nPw);
					}else {
						System.out.println("Incorrect PW");
					}
					System.out.print("이름 >>");
					String nName = sc.next();
					naver.setnName(nName);
					System.out.println("생년월일");
					System.out.print("연도 >>");
					String nYear = sc.next();
					System.out.print("월 >>");
					String nMon = sc.next();
					System.out.print("일 >>");
					String nDay = sc.next();
					naver.setnBirth(nYear+nMon+nDay);
					
					System.out.print("성별 >>");
					String nSex = sc.next();
					naver.setnGender(nSex);
					System.out.print("이메일 >>");
					String nEmail = sc.next();
					naver.setnEmail(nEmail);
					System.out.print("전화번호 >>");
					String nPhone = sc.next();
					naver.setnPhone(nPhone);
					
					server.memberJoin(naver);
					break;		
			case 4: System.out.print("관리자아이디 >>");
					String adminId = sc.next();
					System.out.print("비밀번호 >>");
					String adminPW = sc.next();
					if(adminId.equals("admin")) {
						server.memberList(); 
					}else {
						System.out.println("관리자가 아닙니다.");
					}
					
					break;
			case 5: System.out.println("수정할 회원정보 입력");
					System.out.print("아이디 >>");
					String modId = sc.next();
					System.out.print("비밀번호 >>");
					String modPW = sc.next();
					
					boolean check = server.idCheck(modId,modPW);
					if(check) {
						System.out.print("아이디 >>");
						nId = sc.next();
						naver.setnID(nId);
						System.out.print("비밀번호 >>");
						nPw = sc.next();
						System.out.print("비밀번호 확인 >>");
						nPwc = sc.next();
						if(nPw.equals(nPwc)) {
							System.out.println("Correct PW");
							naver.setnPW(nPw);
						}else {
							System.out.println("Incorrect PW");
						}
						System.out.print("이름 >>");
						nName = sc.next();
						naver.setnName(nName);
						System.out.println("생년월일");
						System.out.print("연도 >>");
						nYear = sc.next();
						System.out.print("월 >>");
						nMon = sc.next();
						System.out.print("일 >>");
						nDay = sc.next();
						naver.setnBirth(nYear+nMon+nDay);
						
						System.out.print("성별 >>");
						nSex = sc.next();
						naver.setnGender(nSex);
						System.out.print("이메일 >>");
						nEmail = sc.next();
						naver.setnEmail(nEmail);
						System.out.print("전화번호 >>");
						nPhone = sc.next();
						naver.setnPhone(nPhone);
						
						server.memberModify(naver);
					}else {
						System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
					}
					break;
			case 6: System.out.println("삭제할 회원정보 입력");
					System.out.print("아이디 >>");
					String delId = sc.next();
					System.out.print("비밀번호 >>");
					String delPW = sc.next();
					
					check = server.idCheck(delId,delPW);
					if(check) {
						server.memberDelete(delId);
					}else {
						System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
					}
					break;
			case 7: op=false; break;
			default: System.out.println("다시 메뉴를 선택해주세요.");
					 break;
			}
		}
	}

}
