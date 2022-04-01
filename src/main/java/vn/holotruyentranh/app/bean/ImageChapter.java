package vn.holotruyentranh.app.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ImageChapter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdImageChapter;
	private Long IDchapter;
	private String ImageLink;
	
	public ImageChapter() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getIdImageChapter() {
		return IdImageChapter;
	}
	public void setIdImageChapter(Long idImageChapter) {
		IdImageChapter = idImageChapter;
	}
	public Long getIDchapter() {
		return IDchapter;
	}
	public void setIDchapter(Long iDchapter) {
		IDchapter = iDchapter;
	}
	public String getImageLink() {
		return ImageLink;
	}
	public void setImageLink(String imageLink) {
		ImageLink = imageLink;
	}
	
	
}
