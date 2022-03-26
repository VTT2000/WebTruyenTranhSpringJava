package vn.holotruyentranh.beans;

public class Author {
	private int IDauthor;
	private String author;
	private String created;
	private String updated;
	
	public Author() {
		// TODO Auto-generated constructor stub
	}
	
	public int getIDauthor() {
		return IDauthor;
	}
	public void setIDauthor(int iDauthor) {
		IDauthor = iDauthor;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
