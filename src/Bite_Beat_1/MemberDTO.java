package Bite_Beat_1;

public class MemberDTO {
	private String id;
	private String pwd;
	private int score;
	private int rank;
	private String star;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	@Override
	public String toString() {
		return "MemberDTO [id = " + id + ", pwd = " + pwd;
	}

}
