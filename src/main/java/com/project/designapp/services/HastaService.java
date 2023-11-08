package com.project.designapp.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.project.designapp.entities.Hasta;
import com.project.designapp.repos.HastaRepository;

@Service
public class HastaService {

	HastaRepository hastaRepository;

	public HastaService(HastaRepository hastaRepository) {
		
		this.hastaRepository = hastaRepository;
	}

	public List<Hasta> getAllHasta() {
		return hastaRepository.findAll();
	}

	public Hasta saveOneHasta(Hasta newHasta) {
		return hastaRepository.save(newHasta);
	}

	public Hasta getOneHasta(Long hastaId) {
		return hastaRepository.findById(hastaId).orElse(null);
	}

	public Hasta updateOneHasta(Long h_id, Hasta newHasta) {
		Optional<Hasta> hasta=hastaRepository.findById(h_id);
		if(hasta.isPresent()) {
			Hasta foundHasta=hasta.get();
			foundHasta.setAdi(newHasta.getAdi()); 
			hastaRepository.save(foundHasta);
			return foundHasta;
		}else
			return null;
	}

	public void deleteById(Long hastaId) {
		hastaRepository.deleteById(hastaId);
	}
	
	
}

