package com.cognizant.moviecruiser.model;

import java.util.Date;

public class Movies {
	private long id;
	private String title;
	private long gross;
	private Boolean active;
	private Date dateOfLaunch;
	private String genre;
	private Boolean hasTeaser;
	
	public Movies(long id, String title, long gross, Boolean active, Date dateOfLaunch, String genre,
			Boolean hasTeaser) {
		super();
		this.id = id;
		this.title = title;
		this.gross = gross;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
	}
	public Movies() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getGross() {
		return gross;
	}
	public void setGross(long gross) {
		this.gross = gross;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}
	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Boolean getHasTeaser() {
		return hasTeaser;
	}
	public void setHasTeaser(Boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}
	
}
