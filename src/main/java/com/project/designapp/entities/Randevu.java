package com.project.designapp.entities;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
@Table(name="randevu")


public class Randevu {
	@Id
	Long id;
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="hasta_id",nullable=false)
    @OnDelete(action=OnDeleteAction.CASCADE) 
	@JsonIgnore
	Hasta hasta;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="doktor_id",nullable=false)
    @OnDelete(action=OnDeleteAction.CASCADE) 
	@JsonIgnore
	Doktor doktor;

	
    Date tarih;
    String randevuAciklamasi;
    
    
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
	public Doktor getDoktor() {
		return doktor;
	}
	public void setDoktor(Doktor doktor) {
		this.doktor = doktor;
	}
	public Date getTarih() {
		return tarih;
	}
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	public String getRandevuAciklamasi() {
		return randevuAciklamasi;
	}
	public void setRandevuAciklamasi(String randevuAciklamasi) {
		this.randevuAciklamasi = randevuAciklamasi;
	}
    
    
    
}
