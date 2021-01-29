package bank;

import java.util.Scanner;

public class BankMain {

	public static void main(String[] args) {

			BankDTO client = new BankDTO();
			BankDAO server = new BankDAO();
			Scanner scan = new Scanner(System.in);
			
			boolean op = true;
			int menu = 0;
			
			while(op) {
				System.out.println("===============================");
				System.out.println("1.계좌생성 		2.입금	3.출금");
				System.out.println("4.잔액조회		5.송금	6.종료 ");
				System.out.println("===============================");
				System.out.print("메뉴를 선택 하시오 >> ");
				menu = scan.nextInt();
				server.connect();
				
				switch(menu) {
				case 1: int clientNo = server.clientNumber()+1;
						System.out.println("회원정보 입력");
						System.out.print("회원이름 >> ");
						String cName = scan.next();
						System.out.print("계좌번호 >> ");
						String accNumber = scan.next();
						System.out.print("초기 입금액 >> ");
						int balance = scan.nextInt();
						client = new BankDTO(clientNo, cName, accNumber, balance);
						
						server.insertClient(client);
						break;
				case 2: System.out.print("계좌번호 >> ");
						accNumber = scan.next();
						System.out.print("입금할 금액 >> ");
						balance = scan.nextInt();
						
						client.setAccNumber(accNumber);
						client.setBalance(balance);
						
						server.deposit(client);// 입금 메소드 1
						//server.deposit(accNumber,balance);// 입금 메소드 2
						break;
				case 3: System.out.print("계좌번호 >> ");
						accNumber = scan.next();
						System.out.print("출금할 금액 >> ");
						balance = scan.nextInt();
						int cBalance = server.checkBalance(accNumber);
						if(balance>cBalance) {
							System.out.println("잔액이 원하시는 출금액보다 "+(balance-cBalance)+"원 부족합니다.");
							System.out.println("현재 잔액은 "+cBalance+"원 입니다.");
						}else {
							//client.setAccNumber(accNumber);
							//client.setBalance(balance);
						
							//server.withdraw(client);// 입금 메소드 1
							server.withdraw(accNumber,balance);// 입금 메소드 2
						}
						break;
				case 4: System.out.print("잔액조회할 계좌번호 >> ");
						accNumber = scan.next();
						
						balance = server.checkBalance(accNumber);
						break;
				case 5: System.out.print("송금할 계좌번호 >> ");
						String rAccNumber = scan.next();
						System.out.print("송금할 금액 >> ");
						balance = scan.nextInt();
						System.out.print("송금받을 계좌번호 >> ");
						String sAccNumber = scan.next();
						cBalance = server.checkBalance(rAccNumber);
						
						boolean cRAccNo = server.checkAccNumber(rAccNumber);
						if(cRAccNo) {
							boolean cSAccNo = server.checkAccNumber(sAccNumber);
							if(cSAccNo) {
								if(balance>cBalance) {
									System.out.println("잔액이 원하시는 송금액보다 "+(balance-cBalance)+"원 부족합니다.");
									System.out.println("현재 잔액은 "+cBalance+"원 입니다.");
								}else {
									server.transfer(rAccNumber,balance,sAccNumber);
								}
							}else {
									System.out.println("송금할 계좌번호가 틀립니다.");
							}
						}else {
								System.out.println("송금받을 계좌번호가 틀립니다.");
						}	
						break;
				case 6: op = false;
						System.out.println("이용해 주셔서 감사합니다.");
						break;
				default: System.out.println("다시 메뉴를 선택해주세요.");
						 break;
				}
				server.conClose();
			}
			
	}

}
