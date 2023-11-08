package com.project.designapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.designapp.entities.Doktor;
import com.project.designapp.entities.Hasta;
import com.project.designapp.entities.Randevu;
import com.project.designapp.repos.RandevuRepository;
import com.project.designapp.requests.RandevuCreateRequest;
import com.project.designapp.requests.RandevuUpdateRequest;

@Service
public class RandevuService {
	
	RandevuRepository randevuRepository;
	private HastaService hastaService;
	private DoktorService doktorService;
	
	
	
	public RandevuService(RandevuRepository randevuRepository, HastaService hastaService, DoktorService doktorService) {
		this.randevuRepository = randevuRepository;
		this.hastaService = hastaService;
		this.doktorService = doktorService;
	}



	public List<Randevu> getAllHastaRandevu(Optional<Long> hastaId) {
		if(hastaId.isPresent())
			return randevuRepository.findByHastaId(hastaId.get());
		return randevuRepository.findAll();
	}



	public List<Randevu> getAllDoktorRandevu(Optional<Long> doktorId) {
		if(doktorId.isPresent())
			return randevuRepository.findByDoktorId(doktorId.get());
		return randevuRepository.findAll();
	}



	public Randevu createRandevu(RandevuCreateRequest newRandevuRequest) {
		Hasta hasta=hastaService.getOneHasta(newRandevuRequest.getHastaId());
		if(hasta==null)
			return null;
		Doktor doktor=doktorService.getOneDoktor(newRandevuRequest.getDoktorId());
		if(doktor==null)
			return null;
		Randevu toSave=new Randevu();
		toSave.setId(newRandevuRequest.getId());
		toSave.setTarih(newRandevuRequest.getTarih());
		toSave.setRandevuAciklamasi(newRandevuRequest.getRandevuAciklamasi());
		toSave.setHasta(hasta);
		toSave.setDoktor(doktor);
		return randevuRepository.save(toSave);
	}



	public Randevu getOneRandevu(Long randeuvId) {
		return randevuRepository.findById(randeuvId).orElse(null);
	}



	public Randevu updateOneFatura(Long randevuId, RandevuUpdateRequest randevuUpdate) {
		Optional<Randevu> randevu=randevuRepository.findById(randevuId);
		if(randevu.isPresent()) {
			Randevu toUpdate=randevu.get();
			toUpdate.setTarih(randevuUpdate.getTarih());
			toUpdate.setRandevuAciklamasi(randevuUpdate.getRandevuAciklamasi());
			randevuRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}

	public void deleteOneFatura(Long randevuId) {
		randevuRepository.deleteById(randevuId);
	}

}
