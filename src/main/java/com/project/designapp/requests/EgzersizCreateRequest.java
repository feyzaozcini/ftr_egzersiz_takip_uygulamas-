package com.project.designapp.requests;

import lombok.Data;

@Data
public class EgzersizCreateRequest {
	Long id;
	String egzersizAdi;
	String egzersizTarifi;


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
}
