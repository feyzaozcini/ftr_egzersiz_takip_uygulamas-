package com.project.designapp.requests;

import java.util.Date;

import lombok.Data;

@Data
public class FaturaCreateRequest {
	Long id;
	Date tarih;
	int ücret;
	Long hastaId;
	Long yöneticiId;
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
	public int getÜcret() {
		return ücret;
	}
	public void setÜcret(int ücret) {
		this.ücret = ücret;
	}
	public Long getHastaId() {
		return hastaId;
	}
	public void setHastaId(Long hastaId) {
		this.hastaId = hastaId;
	}
	public Long getYöneticiId() {
		return yöneticiId;
	}
	public void setYöneticiId(Long yöneticiId) {
		this.yöneticiId = yöneticiId;
	}
	
	
	
}
