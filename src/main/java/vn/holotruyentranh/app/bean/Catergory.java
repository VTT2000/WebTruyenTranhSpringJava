package vn.holotruyentranh.app.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Catergory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDcatergory;
	private String catergory;
	private String description;
	private String created_at;
	private String update_at;
	
	public Catergory() {
		// TODO Auto-generated constructor stub
	}

	public Long getIDcatergory() {
		return IDcatergory;
	}

	public void setIDcatergory(Long iDcatergory) {
		IDcatergory = iDcatergory;
	}

	public String getCatergory() {
		return catergory;
	}

	public void setCatergory(String catergory) {
		this.catergory = catergory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}
	
	
}
