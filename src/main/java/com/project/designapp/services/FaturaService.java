package com.project.designapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.designapp.entities.Fatura;
import com.project.designapp.entities.Hasta;
import com.project.designapp.repos.FaturaRepository;
import com.project.designapp.requests.FaturaCreateRequest;
import com.project.designapp.requests.FaturaUpdateRequest;

@Service
public class FaturaService {
	
	FaturaRepository faturaRepository;
	private HastaService hastaService;
	
	
	public FaturaService(FaturaRepository faturaRepository,HastaService hastaService) {
		this.faturaRepository = faturaRepository;
		this.hastaService=hastaService;
	}

	public List<Fatura> getAllFatura(Optional<Long> hastaId) {
		if(hastaId.isPresent())
			return faturaRepository.findByHastaId(hastaId.get());
		return faturaRepository.findAll();
	}

	public Fatura createFatura(FaturaCreateRequest newFaturaRequest) {
		Hasta hasta=hastaService.getOneHasta(newFaturaRequest.getHastaId());
		if(hasta==null)
			return null;
		Fatura toSave=new Fatura();
		toSave.setId(newFaturaRequest.getId());
		toSave.setTarih(newFaturaRequest.getTarih());
		toSave.setÜcret(newFaturaRequest.getÜcret());
		toSave.setHasta(hasta);
		return faturaRepository.save(toSave);
	}

	
	public Fatura getOneFatura(Long faturaId) {
		return faturaRepository.findById(faturaId).orElse(null);
	}

	public Fatura updateOneFatura(Long faturaId, FaturaUpdateRequest faturaUpdate) {
		Optional<Fatura> fatura=faturaRepository.findById(faturaId);
		if(fatura.isPresent()) {
			Fatura toUpdate=fatura.get();
			toUpdate.setTarih(faturaUpdate.getTarih());
			toUpdate.setÜcret(faturaUpdate.getÜcret());
			faturaRepository.save(toUpdate);
			return toUpdate;
		}
		
		return null;
	}

	public void deleteOneFatura(Long faturaId) {
		faturaRepository.deleteById(faturaId);
	}

	public List<Fatura> getAllFaturalar() {
		return faturaRepository.findAll();
	}
}
