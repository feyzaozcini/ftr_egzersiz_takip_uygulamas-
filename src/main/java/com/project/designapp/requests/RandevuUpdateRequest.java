package com.project.designapp.requests;

import java.util.Date;

import lombok.Data;

@Data
public class RandevuUpdateRequest {
	Date tarih;
    String randevuAciklamasi;
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
