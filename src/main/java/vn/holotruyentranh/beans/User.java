package vn.holotruyentranh.beans;

public class User {
	private int IDuser;
	private String mail;
	private String password;
	private String username;
	private String created;
	private	String updated;
	private int IDteam;
	private int	IDtransper;
	private int	IDper;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public int getIDuser() {
		return IDuser;
	}
	public void setIDuser(int iDuser) {
		IDuser = iDuser;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public int getIDteam() {
		return IDteam;
	}
	public void setIDteam(int iDteam) {
		IDteam = iDteam;
	}
	public int getIDtransper() {
		return IDtransper;
	}
	public void setIDtransper(int iDtransper) {
		IDtransper = iDtransper;
	}
	public int getIDper() {
		return IDper;
	}
	public void setIDper(int iDper) {
		IDper = iDper;
	}
	
	
}
