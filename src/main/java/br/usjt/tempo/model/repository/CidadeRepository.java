package br.usjt.tempo.model.repository;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.usjt.tempo.model.Cidade;

public interface CidadeRepository extends JpaRepository <Cidade, Long>{

	//Cidade getOne(String letra);
	
	@Query(value = "SELECT * FROM cidade c WHERE c.latitude = ?1", 
			  nativeQuery = true)
	Cidade getFromLatitude(Long Latitude);
	
	@Query(value = "SELECT * FROM cidade c WHERE c.longitude = ?1", 
			  nativeQuery = true)
	Cidade getFromLongitude(Long Longitude);
	
	
}