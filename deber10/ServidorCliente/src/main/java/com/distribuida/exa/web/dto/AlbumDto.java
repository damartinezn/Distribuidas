package com.distribuida.exa.web.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class AlbumDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Getter @Setter private Integer id; 
	@Getter @Setter private Integer idsinger;
	@Getter @Setter private String title;
	@Getter @Setter private Date releasedate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdsinger() {
		return idsinger;
	}
	public void setIdsinger(Integer idsinger) {
		this.idsinger = idsinger;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	
	
	
}
