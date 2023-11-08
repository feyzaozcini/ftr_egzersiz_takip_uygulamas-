package com.project.designapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.designapp.entities.Doktor;

public interface DoktorRepository extends JpaRepository<Doktor, Long> {

}
