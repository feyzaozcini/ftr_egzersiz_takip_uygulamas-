package com.project.designapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.designapp.entities.Yönetici;
import com.project.designapp.services.YöneticiService;

@RestController
@RequestMapping("/yönetici")
public class YöneticiController {
	YöneticiService yöneticiService;

	public YöneticiController(YöneticiService yöneticiService) {
		super();
		this.yöneticiService = yöneticiService;
	}
	
	//Yönetici sadece bir kişi ve bu kişi sadece bilgilerini görebilir 
	
	@GetMapping 
    public List<Yönetici> getYönetici(){
	    return yöneticiService.getYönetici();
 }
}
