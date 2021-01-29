package jdbc0120;

import java.util.Scanner;

public class stuMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean op = true;
		StuDTO stu = new StuDTO();
		stuSQL sql = new stuSQL();
		Scanner sc = new Scanner(System.in);
		while(op) {
			System.out.println("===============================");
			System.out.println("1.DB접속 2.DB해제 3.학생등록  4.학생조회");
			System.out.println("5.학생수정 6.학생삭제 7.종료");
			System.out.println("===============================");
			System.out.print("메뉴를 선택 하시오 >> ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1: sql.connect();
					break;
			case 2: sql.conClose();
					break;
			case 3: System.out.println("학생정보 입력");
					System.out.print("이름 >>");
					String stuName = sc.next();
					System.out.print("나이 >>");
					int stuAge = sc.nextInt();
					stu.setStuName(stuName);
					stu.setStuAge(stuAge);
					
					sql.insert(stu);
					break;		
			case 4: sql.select(); break;
			case 5: System.out.println("수정할 학생정보 입력");
					System.out.print("이름 >>");
					String sname = sc.next();
					System.out.print("나이 >>");
					int sage = sc.nextInt();
					stu.setStuName(sname);
					stu.setStuAge(sage);
					
					sql.update(stu);
					break;
			case 6: System.out.println("삭제할 학생정보 입력");
					System.out.print("이름 >>");
					String delName = sc.next();
					sql.delete(delName);
					break;
			case 7: op=false; break;
			}
		}
	}

}
