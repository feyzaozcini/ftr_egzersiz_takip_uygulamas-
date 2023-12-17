package com.project.designapp.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="egzersiz")


public class Egzersiz {
	@Id
	Long id;


	@ManyToMany(mappedBy = "egzersizler")
	private List<Hasta> hastalar = new ArrayList<>();

	public List<Hasta> getHastalar() {
		return hastalar;
	}

	public void setHastalar(List<Hasta> hastalar) {
		this.hastalar = hastalar;
	}

	String egzersizAdi;
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
	String egzersizTarifi;
	
}
