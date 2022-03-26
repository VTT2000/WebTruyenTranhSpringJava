package vn.holotruyentranh.beans;

public class Comic {
	private int IDcomic;
	private String comic;
	private String created;
	private String updated;
	private int	ratting;
	private int	views;
	private int	share;
	private int	IDauthor;
	private String status;
	private String description;
	private String ImageLink;
	
	public Comic() {
		// TODO Auto-generated constructor stub
	}
	
	public int getIDcomic() {
		return IDcomic;
	}
	public void setIDcomic(int iDcomic) {
		IDcomic = iDcomic;
	}
	public String getComic() {
		return comic;
	}
	public void setComic(String comic) {
		this.comic = comic;
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
	public int getRatting() {
		return ratting;
	}
	public void setRatting(int ratting) {
		this.ratting = ratting;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getShare() {
		return share;
	}
	public void setShare(int share) {
		this.share = share;
	}
	public int getIDauthor() {
		return IDauthor;
	}
	public void setIDauthor(int iDauthor) {
		IDauthor = iDauthor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageLink() {
		return ImageLink;
	}
	public void setImageLink(String imageLink) {
		ImageLink = imageLink;
	}
	
}
