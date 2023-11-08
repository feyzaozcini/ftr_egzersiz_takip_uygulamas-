package com.project.designapp.requests;

import java.util.Date;

import lombok.Data;
@Data
public class FaturaUpdateRequest {
	Date tarih;
	int ücret;
	
	
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
