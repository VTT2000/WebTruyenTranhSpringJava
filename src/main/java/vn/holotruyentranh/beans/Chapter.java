package vn.holotruyentranh.beans;

public class Chapter {
	private int IDchapter;
	private String chapter;
	private int IDcomic;
	private String created;
	private String updated;
	
	public Chapter() {
		// TODO Auto-generated constructor stub
	}
	
	public int getIDchapter() {
		return IDchapter;
	}
	public void setIDchapter(int iDchapter) {
		IDchapter = iDchapter;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public int getIDcomic() {
		return IDcomic;
	}
	public void setIDcomic(int iDcomic) {
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
