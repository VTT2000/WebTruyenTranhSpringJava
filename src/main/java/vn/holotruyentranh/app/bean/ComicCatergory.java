package vn.holotruyentranh.app.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ComicCatergory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long IDcatergory;
	private Long IDcomic;
	
	public ComicCatergory() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIDcatergory() {
		return IDcatergory;
	}

	public void setIDcatergory(Long iDcatergory) {
		IDcatergory = iDcatergory;
	}

	public Long getIDcomic() {
		return IDcomic;
	}

	public void setIDcomic(Long iDcomic) {
		IDcomic = iDcomic;
	}

}
