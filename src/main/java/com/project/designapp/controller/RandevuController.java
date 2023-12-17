package com.project.designapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.designapp.entities.Randevu;
import com.project.designapp.requests.RandevuCreateRequest;
import com.project.designapp.requests.RandevuUpdateRequest;
import com.project.designapp.services.RandevuService;

@RestController
@RequestMapping("/api/v1/randevular")
public class RandevuController {
	RandevuService randevuService;

	public RandevuController(RandevuService randevuService) {
		this.randevuService = randevuService;
	}
	//Hastanın randevularını getirmek için
	@GetMapping ("/hastaRandevu")
    public List<Randevu> getAllHastaRandevu(@RequestParam Optional<Long> hastaId){
	    return randevuService.getAllHastaRandevu(hastaId);
    }
	
	//Doktorun randevularını getirmek için
	@GetMapping("/doktorRandevu")
    public List<Randevu> getAllDoktorRandevu(@RequestParam Optional<Long> doktorId){
	    return randevuService.getAllDoktorRandevu(doktorId);
    }
	
	@PostMapping 
	public Randevu createRandevu(@RequestBody RandevuCreateRequest newRandevuRequest) {
		return randevuService.createRandevu(newRandevuRequest);
	}
	
	 @GetMapping("/{randevuId}")
	public Randevu getOneRandevu(@PathVariable Long randeuvId) {
		return randevuService.getOneRandevu(randeuvId);
	}
	 
	@PutMapping("/{randevuId}")
	public Randevu updateOneFatura(@PathVariable Long randevuId,@RequestBody RandevuUpdateRequest randevuUpdate) {
		 return randevuService.updateOneFatura(randevuId,randevuUpdate);
	}
	   
    @DeleteMapping("/{randevuId}")
    public void deleteOneRandevu(@PathVariable Long randevuId) {
    	randevuService.deleteOneFatura(randevuId);
	}	 
	
	
	
}
