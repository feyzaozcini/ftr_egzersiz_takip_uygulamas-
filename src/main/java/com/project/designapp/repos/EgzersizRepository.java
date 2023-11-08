package com.project.designapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.designapp.entities.Egzersiz;

public interface EgzersizRepository extends JpaRepository<Egzersiz, Long> {

	List<Egzersiz> findByHastaId(Long hastaId);

}
