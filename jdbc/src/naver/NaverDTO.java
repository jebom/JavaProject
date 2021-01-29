package naver;

public class NaverDTO {
	private String nID;
	private String nPW;
	private String nName;
	private String nBirth;
	private String nGender;
	private String nEmail;
	private String nPhone;

	public String getnID() {
		return nID;
	}

	public void setnID(String nID) {
		this.nID = nID;
	}

	public String getnPW() {
		return nPW;
	}

	public void setnPW(String nPW) {
		this.nPW = nPW;
	}

	public String getnName() {
		return nName;
	}

	public void setnName(String nName) {
		this.nName = nName;
	}

	public String getnBirth() {
		return nBirth;
	}

	public void setnBirth(String nBirth) {
		this.nBirth = nBirth;
	}

	public String getnGender() {
		return nGender;
	}

	public void setnGender(String nGender) {
		this.nGender = nGender;
	}

	public String getnEmail() {
		return nEmail;
	}

	public void setnEmail(String nEmail) {
		this.nEmail = nEmail;
	}

	public String getnPhone() {
		return nPhone;
	}

	public void setnPhone(String nPhone) {
		this.nPhone = nPhone;
	}

	@Override
	public String toString() {
		return "NaverDTO [nID=" + nID + ", nPW=" + nPW + ", nName=" + nName + ", nBirth=" + nBirth + ", nGender="
				+ nGender + ", nEmail=" + nEmail + ", nPhone=" + nPhone + "]";
	}

	public NaverDTO(String nID, String nPW, String nName, String nBirth, String nGender, String nEmail, String nPhone) {
		this.nID = nID;
		this.nPW = nPW;
		this.nName = nName;
		this.nBirth = nBirth;
		this.nGender = nGender;
		this.nEmail = nEmail;
		this.nPhone = nPhone;
	}

	public NaverDTO() {
	}
	
}
