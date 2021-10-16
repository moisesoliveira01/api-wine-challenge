package com.desafioapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafioapi.model.Cep;

public interface CepRepository extends JpaRepository<Cep, Long>{

	
}
