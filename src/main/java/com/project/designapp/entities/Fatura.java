package com.project.designapp.entities;

import java.util.Date;


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
@Table(name="fatura")

public class Fatura {
	@Id
	Long id;
	@ManyToOne(fetch=FetchType.LAZY) //Bir hastanın birden fazla faturası
	@JoinColumn(name="hasta_id",nullable=false)
	@JsonIgnore
	Hasta hasta;
	
	@ManyToOne(fetch=FetchType.LAZY) //Bir hastanın birden fazla faturası
	@JoinColumn(name="yönetici_id",nullable=false)
	@JsonIgnore
	Yönetici yönetici;
	
	Date tarih;
	int ücret;
	
	
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
	public Yönetici getYönetici() {
		return yönetici;
	}
	public void setYönetici(Yönetici yönetici) {
		this.yönetici = yönetici;
	}
	public Date getTarih() {
		return tarih;
	}
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	public int getÜcret() {
		return ücret;
	}
	public void setÜcret(int ücret) {
		this.ücret = ücret;
	}
	
}
