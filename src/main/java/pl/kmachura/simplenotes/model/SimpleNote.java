package pl.kmachura.simplenotes.model;

import java.util.Date;

public class SimpleNote {
	private int id;
	private String title;
	private String content;
	private Date creationDate;
	private Date modificationDate;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Date getModificationDate() {
		return modificationDate;
	}
	
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	public SimpleNote() {}
	
	public SimpleNote(int id, String title, String content, Date creationDate, Date modificationDate) {
		setId(id);
		setTitle(title);
		setContent(content);
		setCreationDate(creationDate);
		setModificationDate(modificationDate);
	}

	@Override
	public String toString() {
		return id + " " + title + " " + content + " " + creationDate
				+ " " + modificationDate;
	}
	
	
	
	
	
}