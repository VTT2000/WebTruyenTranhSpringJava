package vn.holotruyentranh.app.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ComicTrans {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long IDcomic;
	private Long IDteam;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ComicTrans() {
		// TODO Auto-generated constructor stub
	}

	public Long getIDcomic() {
		return IDcomic;
	}

	public void setIDcomic(Long iDcomic) {
		IDcomic = iDcomic;
	}

	public Long getIDteam() {
		return IDteam;
	}

	public void setIDteam(Long iDteam) {
		IDteam = iDteam;
	}
	
	
	
}
