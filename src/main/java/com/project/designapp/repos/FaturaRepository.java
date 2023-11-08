package com.project.designapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.designapp.entities.Fatura;

public interface FaturaRepository extends JpaRepository<Fatura, Long> {

	List<Fatura> findByHastaId(Long hastaId);

}
