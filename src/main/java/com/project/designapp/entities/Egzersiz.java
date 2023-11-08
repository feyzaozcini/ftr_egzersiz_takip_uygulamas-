package com.project.designapp.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="egzersiz")


public class Egzersiz {
	@Id
	Long id;
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="hasta_id",nullable=false)
	@JsonIgnore
	Hasta hasta;
	
	
	
	String egzersizAdi;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Hasta getHasta() {
		return hasta;
	}
	public void setHasta(Hasta hasta) {
		this.hasta = hasta;
	}
	public String getEgzersizAdi() {
		return egzersizAdi;
	}
	public void setEgzersizAdi(String egzersizAdi) {
		this.egzersizAdi = egzersizAdi;
	}
	public String getEgzersizTarifi() {
		return egzersizTarifi;
	}
	public void setEgzersizTarifi(String egzersizTarifi) {
		this.egzersizTarifi = egzersizTarifi;
	}
	String egzersizTarifi;
	
}
