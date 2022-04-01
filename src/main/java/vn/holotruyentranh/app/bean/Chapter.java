package vn.holotruyentranh.app.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chapter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDchapter;
	private String chapter;
	private Long IDcomic;
	private String created;
	private String updated;
	
	public Chapter() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getIDchapter() {
		return IDchapter;
	}
	public void setIDchapter(Long iDchapter) {
		IDchapter = iDchapter;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public Long getIDcomic() {
		return IDcomic;
	}
	public void setIDcomic(Long iDcomic) {
		IDcomic = iDcomic;
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
}
