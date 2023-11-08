package com.project.designapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.designapp.entities.Doktor;
import com.project.designapp.services.DoktorService;

@RestController
@RequestMapping("/doktorlar")
public class DoktorController {
	 public DoktorService doktorService;
	 
	 public DoktorController(DoktorService doktorService) {
		 this.doktorService = doktorService;
	 }
	 
	 @GetMapping 
	    public List<Doktor> getAllDoktor(){
		    return doktorService.getAllDoktor();
	 }
	 @PostMapping
		public Doktor createDoktor(@RequestBody Doktor newDoktor) {
			return doktorService.saveOneDoktor(newDoktor);
	}
		
	@GetMapping("/{doktorId}")
		public Doktor getOneDoktor(@PathVariable Long doktorId) { 
		    return doktorService.getOneDoktor(doktorId);
	}
		
	@PutMapping("/{doktorId}")
	public Doktor updateOneDoktor(@PathVariable Long doktorId, @RequestBody Doktor newDoktor) {
		return doktorService.updateOneDoktor(doktorId, newDoktor); 
	}
	@DeleteMapping ("/{doktorId}")
		public void deleteOneDoktor(@PathVariable Long doktorId) {
			doktorService.deleteById(doktorId);
	}
	
}