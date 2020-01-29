package com.distribuida.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "singer")
public class Singer {

		@Id
		@Column(name = "idsinger")
		private Integer idSinger;
		@Column(name = "firstname")
		private String firstName;
		@Column(name = "lastname")
		private String lastName;
		
		@Temporal(TemporalType.DATE)
		@Column(name = "birthdate")
		private Date birthDate;

		public Integer getIdSinger() {
			return idSinger;
		}

		public void setIdSinger(Integer idSinger) {
			this.idSinger = idSinger;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Date getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(Date birthDate) {
			this.birthDate = birthDate;
		}

		
	
		
}
