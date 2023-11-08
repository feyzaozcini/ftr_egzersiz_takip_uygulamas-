package com.project.designapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.designapp.entities.Yönetici;
import com.project.designapp.repos.YöneticiRepository;


@Service
public class YöneticiService {
	YöneticiRepository yöneticiRepository;

	public YöneticiService(YöneticiRepository yöneticiRepository) {
		this.yöneticiRepository = yöneticiRepository;
	}

	public List<Yönetici> getYönetici() {
		return yöneticiRepository.findAll();
	}

	
	
	
}
