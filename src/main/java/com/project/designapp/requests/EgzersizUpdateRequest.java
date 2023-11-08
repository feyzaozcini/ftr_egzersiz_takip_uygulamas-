package com.project.designapp.requests;

import lombok.Data;

@Data
public class EgzersizUpdateRequest {
	String egzersizAdi;
	String egzersizTarifi;
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
