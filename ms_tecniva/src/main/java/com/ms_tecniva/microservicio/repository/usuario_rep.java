package com.ms_tecniva.microservicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms_tecniva.microservicio.model.usuario_mdl;

@Repository
public interface usuario_rep extends JpaRepository<usuario_mdl, Long> {
}