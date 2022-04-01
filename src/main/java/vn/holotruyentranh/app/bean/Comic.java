package vn.holotruyentranh.app.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDcomic;
	private String comic;
	private String created;
	private String updated;
	private Long ratting;
	private Long views;
	private Long share;
	private Long IDauthor;
	private String status;
	private String description;
	private String ImageLink;
	
	public Comic() {
		// TODO Auto-generated constructor stub
	}

	public Long getIDcomic() {
		return IDcomic;
	}

	public void setIDcomic(Long iDcomic) {
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

	public Long getRatting() {
		return ratting;
	}

	public void setRatting(Long ratting) {
		this.ratting = ratting;
	}

	public Long getViews() {
		return views;
	}

	public void setViews(Long views) {
		this.views = views;
	}

	public Long getShare() {
		return share;
	}

	public void setShare(Long share) {
		this.share = share;
	}

	public Long getIDauthor() {
		return IDauthor;
	}

	public void setIDauthor(Long iDauthor) {
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
