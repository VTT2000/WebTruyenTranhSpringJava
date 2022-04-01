package vn.holotruyentranh.app.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDuser;
	private String mail;
	private String password;
	private String username;
	private String created;
	private	String updated;
	private Long IDteam;
	private Long IDtransper;
	private Long IDper;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getIDuser() {
		return IDuser;
	}
	public void setIDuser(Long iDuser) {
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
	public Long getIDteam() {
		return IDteam;
	}
	public void setIDteam(Long iDteam) {
		IDteam = iDteam;
	}
	public Long getIDtransper() {
		return IDtransper;
	}
	public void setIDtransper(Long iDtransper) {
		IDtransper = iDtransper;
	}
	public Long getIDper() {
		return IDper;
	}
	public void setIDper(Long iDper) {
		IDper = iDper;
	}
	
	
}
