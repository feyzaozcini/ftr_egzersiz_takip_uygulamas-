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

import com.project.designapp.entities.Hasta;
import com.project.designapp.services.HastaService;


@RestController
@RequestMapping("/api/v1/hastalar")
public class HastaController {
	private HastaService hastaService;
	
	public HastaController(HastaService hastaService) {
		this.hastaService=hastaService;
	}
	
	@GetMapping
	public List<Hasta> getAllHastalar(){
		return hastaService.getAllHasta();
	}
	
	@PostMapping
	public Hasta createHasta(@RequestBody Hasta newHasta) {
		return hastaService.saveOneHasta(newHasta);
	}
	
	@GetMapping("/{hastaId}")
	public Hasta getOneHasta(@PathVariable Long hastaId) {
		return hastaService.getOneHasta(hastaId);
	}
	@PutMapping("/{hastaId}")
	public Hasta updateOneHasta(@PathVariable Long hastaId, @RequestBody Hasta newHasta) {
		return hastaService.updateOneHasta(hastaId, newHasta); 
	}
	
	@DeleteMapping ("/{hastaId}")
	public void deleteOneUser(@PathVariable Long hastaId) {
		hastaService.deleteById(hastaId);
	}
}

