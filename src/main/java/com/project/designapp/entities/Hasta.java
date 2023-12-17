package com.project.designapp.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="hasta")


public class Hasta {
	@Id
	Long id;
	
	String adi;
	String soyadi;
	int telNo;
	String eMail;
	String sifre;

	@ManyToMany
	@JoinTable(
			name = "hasta_egzersiz",
			joinColumns = @JoinColumn(name = "hasta_id"),
			inverseJoinColumns = @JoinColumn(name = "egzersiz_id")
	)
	private List<Egzersiz> egzersizler = new ArrayList<>();
	
	//Getter ve Setter metotları
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getSoyadi() {
		return soyadi;
	}
	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}
	public int getTelNo() {
		return telNo;
	}
	public void setTelNo(int telNo) {
		this.telNo = telNo;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	
}
