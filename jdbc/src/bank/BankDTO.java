package bank;

public class BankDTO {
	private int clientNumber;
	private String cName;
	private String accNumber;
	private int balance;
	
	public int getClientNumber() {
		return clientNumber;
	}
	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankDTO [clientNumber=" + clientNumber + ", cName=" + cName + ", accNumber=" + accNumber + ", balance="
				+ balance + "]";
	}
	public BankDTO(int clientNumber, String cName, String accNumber, int balance) {
		this.clientNumber = clientNumber;
		this.cName = cName;
		this.accNumber = accNumber;
		this.balance = balance;
	}
	public BankDTO() {
	}
	
}
