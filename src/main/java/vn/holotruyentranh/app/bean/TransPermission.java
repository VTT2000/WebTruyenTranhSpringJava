package vn.holotruyentranh.app.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransPermission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDtransper;
	private String transperName;
	
	public TransPermission() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getIDtransper() {
		return IDtransper;
	}
	public void setIDtransper(Long iDtransper) {
		IDtransper = iDtransper;
	}
	public String getTransperName() {
		return transperName;
	}
	public void setTransperName(String transperName) {
		this.transperName = transperName;
	}
	
	
}
