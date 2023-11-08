package com.project.designapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="doktor")

public class Doktor {
	@Id
	Long id;
	
	String adı;
	String soyadı;
	int telNo;
	String eMail;
	int dSüresi;
	String şifre;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdı() {
		return adı;
	}
	public void setAdı(String adı) {
		this.adı = adı;
	}
	public String getSoyadı() {
		return soyadı;
	}
	public void setSoyadı(String soyadı) {
		this.soyadı = soyadı;
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
	public int getdSüresi() {
		return dSüresi;
	}
	public void setdSüresi(int dSüresi) {
		this.dSüresi = dSüresi;
	}
	public String getŞifre() {
		return şifre;
	}
	public void setŞifre(String şifre) {
		this.şifre = şifre;
	}
	
	
	
}