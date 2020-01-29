package com.distribuida.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "album")
public class Album {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "idsinger")
	private Integer idsinger;
	
	@Column(name = "title")
	private String title;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "releasedate")
	private Date releasedate;

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
