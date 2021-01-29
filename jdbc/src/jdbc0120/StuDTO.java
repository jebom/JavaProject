package jdbc0120;

public class StuDTO {
	private String stuName;
	private int stuAge;
	
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	@Override
	public String toString() {
		return "StuDTO [stuName=" + stuName + ", stuAge=" + stuAge + "]";
	}
	
	public StuDTO(String stuName, int stuAge) {
		this.stuName = stuName;
		this.stuAge = stuAge;
	}
	public StuDTO() {
	}
	
}
