package vn.holotruyentranh.app.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransTeam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDteam;
	private String team;
	private String created;
	
	public TransTeam() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getIDteam() {
		return IDteam;
	}
	public void setIDteam(Long iDteam) {
		IDteam = iDteam;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
	
}
