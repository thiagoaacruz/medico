package br.com.hospital.aulaspring.service;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import br.com.hospital.aulaspring.entities.Medico;
import br.com.hospital.aulaspring.repository.IMedicoJPA;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {
	
	@Autowired
	private IMedicoJPA repository; 
	
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException{
		
		String path = "C:\\testejasper";
		
		
		//criar uma lista de empregados vazia para receber os empregados do banco
		
		List<Medico> medico = repository.findAll();
		
		//vamos abrir e compilar
		
		File file = ResourceUtils.getFile("classpath:medico.jrxml");
		
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(medico);
		
	
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("Criado por", "Treinamento CastGroup");
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datasource);
		
		if(reportFormat.equalsIgnoreCase("html")) {
								
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\medico.html");
			
		}
		if(reportFormat.equalsIgnoreCase("pdf")) {
			
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\medico.pdf");
		}
		
		return "report gerado no caminho : " + path;
		
	}


}
