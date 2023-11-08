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

import com.project.designapp.entities.Fatura;
import com.project.designapp.requests.FaturaCreateRequest;
import com.project.designapp.requests.FaturaUpdateRequest;
import com.project.designapp.services.FaturaService;

@RestController
@RequestMapping("/faturalar")
public class FaturaController {
	FaturaService faturaService;

	public FaturaController(FaturaService faturaService) {
		this.faturaService = faturaService;
	}
	
	@GetMapping 
    public List<Fatura> getAllFatura(@RequestParam Optional<Long> hastaId){
	    return faturaService.getAllFatura(hastaId);
    }
	
	@PostMapping 
	public Fatura createFatura(@RequestBody FaturaCreateRequest newFaturaRequest) {
		return faturaService.createFatura(newFaturaRequest);
	}
	
   @GetMapping("/{faturaId}")
	public Fatura getOneFatura(@PathVariable Long faturaId) {
		return faturaService.getOneFatura(faturaId);
	}
   
   @PutMapping("/{faturaId}")
   public Fatura updateOneFatura(@PathVariable Long faturaId,@RequestBody FaturaUpdateRequest faturaUpdate) {
	   return faturaService.updateOneFatura(faturaId,faturaUpdate);
   }
   
   @DeleteMapping("/{faturaId}")
   public void deleteOneFatura(@PathVariable Long faturaId) {
	   faturaService.deleteOneFatura(faturaId);
   }
	
}
