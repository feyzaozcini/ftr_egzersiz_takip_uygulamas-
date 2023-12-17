package com.project.designapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.designapp.entities.Egzersiz;
import com.project.designapp.entities.Hasta;
import com.project.designapp.repos.EgzersizRepository;
import com.project.designapp.requests.EgzersizCreateRequest;
import com.project.designapp.requests.EgzersizUpdateRequest;

@Service
public class EgzersizService {

	EgzersizRepository egzersizRepository;
	private HastaService hastaService;


	public List<Egzersiz> getAllEgzersiz() {
		return egzersizRepository.findAll();
	}

	public EgzersizService(EgzersizRepository egzersizRepository, HastaService hastaService) {
		this.egzersizRepository = egzersizRepository;
		this.hastaService=hastaService;
	}

	public Egzersiz getOneEgzersiz(Long egzersizId) {
		return egzersizRepository.findById(egzersizId).orElse(null);
	}

	public Egzersiz createEgzersiz(EgzersizCreateRequest newEgzersizRequest) {

		Egzersiz toSave=new Egzersiz();
		toSave.setId(newEgzersizRequest.getId());
		toSave.setEgzersizAdi(newEgzersizRequest.getEgzersizAdi());
		toSave.setEgzersizTarifi(newEgzersizRequest.getEgzersizTarifi());
		return egzersizRepository.save(toSave);
	}

	public Egzersiz updateOneEgzersiz(Long egzersizId, EgzersizUpdateRequest egzersizUpdate) {
		Optional<Egzersiz> egzersiz=egzersizRepository.findById(egzersizId);
		if(egzersiz.isPresent()) {
			Egzersiz toUpdate=egzersiz.get();
			toUpdate.setEgzersizAdi(egzersizUpdate.getEgzersizAdi());
			toUpdate.setEgzersizTarifi(egzersizUpdate.getEgzersizTarifi());
			egzersizRepository.save(toUpdate);
			return toUpdate;
		}

		return null;
	}

	public void deleteOneEgzersiz(Long egzersizId) {
		egzersizRepository.deleteById(egzersizId);
	}

}
