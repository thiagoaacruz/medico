package br.com.hospital.aulaspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hospital.aulaspring.entities.Medico;

@Repository
public interface IMedicoRepository extends CrudRepository<Medico, Integer>{

}
