package com.project.designapp.controller;

import java.util.List;
import java.util.Optional;

import com.project.designapp.entities.Role;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
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
@RequestMapping("/api/v1/egzersizler")
public class EgzersizController {
	EgzersizService egzersizService;

	public EgzersizController(EgzersizService egzersizService) {
		this.egzersizService=egzersizService;
	}

	@GetMapping("/admin")
	public List<Egzersiz> getAllEgzersizler(){

		return egzersizService.getAllEgzersiz();

	}

	@GetMapping("/user")
	public List<Egzersiz> getAllEgzersizler(@AuthenticationPrincipal UserDetails userDetails){
		if (userDetails != null && userDetails.getAuthorities().contains(new SimpleGrantedAuthority(Role.USER.name()))) {
			return egzersizService.getAllEgzersiz();
		}
		else {
			throw new AccessDeniedException("Access denied");
		}

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
   
