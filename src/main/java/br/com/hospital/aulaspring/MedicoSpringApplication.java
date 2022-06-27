package br.com.hospital.aulaspring;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.hospital.aulaspring.entities.Medico;
import br.com.hospital.aulaspring.repository.IMedicoJPA;
import br.com.hospital.aulaspring.service.ReportService;
import net.sf.jasperreports.engine.JRException;

@SpringBootApplication
@RestController
public class MedicoSpringApplication {
	
	@Autowired
	private IMedicoJPA repository;
	
	
	@Autowired
	private ReportService service;
	
	
	
	 @GetMapping("/getMedicos")
	 public List<Medico> getEmpregados(){
		 return repository.findAll();
	    }
	
	 
	 
	 @GetMapping("/report/{format}")
	 public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException{
		 return service.exportReport(format);
	    }
	 
	 
	
	

	public static void main(String[] args) {
		SpringApplication.run(MedicoSpringApplication.class, args);
	}

}
