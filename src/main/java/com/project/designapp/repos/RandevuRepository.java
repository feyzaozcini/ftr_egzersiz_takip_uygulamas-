package com.project.designapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.designapp.entities.Randevu;

public interface RandevuRepository extends JpaRepository<Randevu, Long> {

	List<Randevu> findByHastaId(Long hastaId);

	List<Randevu> findByDoktorId(Long doktorId);

}
