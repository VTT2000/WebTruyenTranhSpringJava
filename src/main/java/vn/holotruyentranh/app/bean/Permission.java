package vn.holotruyentranh.app.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Permission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDper;
	private String permission;
	
	public Permission() {
		// TODO Auto-generated constructor stub
	}

	public Long getIDper() {
		return IDper;
	}

	public void setIDper(Long iDper) {
		IDper = iDper;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
}
