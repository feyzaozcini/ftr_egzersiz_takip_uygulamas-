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

import com.project.designapp.entities.Egzersiz;
import com.project.designapp.requests.EgzersizCreateRequest;
import com.project.designapp.requests.EgzersizUpdateRequest;
import com.project.designapp.services.EgzersizService;

@RestController
@RequestMapping("/egzersizler")
public class EgzersizController {
	EgzersizService egzersizService;
	
	public EgzersizController(EgzersizService egzersizService) {
		this.egzersizService=egzersizService;
	}
	
	@GetMapping 
    public List<Egzersiz> getAllEgzersiz(@RequestParam Optional<Long> hastaId){
	    return egzersizService.getAllEgzersiz(hastaId);
    }
	
    @PostMapping 
	public Egzersiz createEgzersiz(@RequestBody EgzersizCreateRequest newEgzersizRequest) {
		return egzersizService.createEgzersiz(newEgzersizRequest);
	}
	
   @GetMapping("/{egzersizId}")
	public Egzersiz getOneEgzersiz(@PathVariable Long egzersizId) {
		return egzersizService.getOneEgzersiz(egzersizId);
	}
   
   @PutMapping("/{egzersizId}")
   public Egzersiz updateOneEgzersiz(@PathVariable Long egzersizId,@RequestBody EgzersizUpdateRequest egzersizUpdate) {
	   return egzersizService.updateOneEgzersiz(egzersizId,egzersizUpdate);
   }
   
   @DeleteMapping("/{egzersizId}")
   public void deleteOneEgzersiz(@PathVariable Long egzersizId) {
	   egzersizService.deleteOneEgzersiz(egzersizId);
   }
}
   
