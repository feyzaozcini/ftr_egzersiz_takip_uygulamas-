package com.project.designapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.designapp.entities.Doktor;
import com.project.designapp.repos.DoktorRepository;


@Service
public class DoktorService {

	DoktorRepository doktorRepository;

	public DoktorService(DoktorRepository doktorRepository) {
		this.doktorRepository = doktorRepository;
	}

	public List<Doktor> getAllDoktor() {
		return doktorRepository.findAll();
	}

	public Doktor saveOneDoktor(Doktor newDoktor) {
		return doktorRepository.save(newDoktor);
	}

	public Doktor getOneDoktor(Long doktorId) {
		return doktorRepository.findById(doktorId).orElse(null);
	}

	public Doktor updateOneDoktor(Long doktorId, Doktor newDoktor) {
		Optional<Doktor> doktor=doktorRepository.findById(doktorId);
		if(doktor.isPresent()) {
			Doktor foundDoktor=doktor.get();
			foundDoktor.setAdı(newDoktor.getAdı()); 
			doktorRepository.save(foundDoktor);
			return foundDoktor;
		}else
			return null;
	}
	
	public void deleteById(Long doktorId) {
		doktorRepository.deleteById(doktorId);
	}

}
