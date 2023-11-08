package com.project.designapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="yönetici")


public class Yönetici {
	@Id 
	Long id;
	String adi;
	String soyadi;
	
}
