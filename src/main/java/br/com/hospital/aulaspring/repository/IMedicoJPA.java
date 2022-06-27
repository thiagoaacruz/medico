package br.com.hospital.aulaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hospital.aulaspring.entities.Medico;

@Repository
public interface IMedicoJPA extends JpaRepository<Medico, Integer> {
	
	
	

}
