package com.project.designapp.requests;

import java.util.Date;

import lombok.Data;
@Data
public class RandevuCreateRequest {
	Long id;
	Date tarih;
    String randevuAciklamasi;
    Long hastaId;
    Long doktorId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getHastaId() {
		return hastaId;
	}
	public void setHastaId(Long hastaId) {
		this.hastaId = hastaId;
	}
	public Long getDoktorId() {
		return doktorId;
	}
	public void setDoktorId(Long doktorId) {
		this.doktorId = doktorId;
	}
    
    
    
}
