package com.project.designapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.designapp.entities.Hasta;

public interface HastaRepository extends JpaRepository<Hasta, Long> {

}
