package br.com.hospital.aulaspring.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.hospital.aulaspring.entities.Medico;
import br.com.hospital.aulaspring.repository.IMedicoRepository;
import br.com.hospital.aulaspring.request.MedicoGetResponse;
import br.com.hospital.aulaspring.request.MedicoPostRequest;
import br.com.hospital.aulaspring.request.MedicoPutRequest;
import io.swagger.annotations.ApiOperation;

@Controller
public class MedicoController {

	@Autowired
	private IMedicoRepository repository;

	// endereço do serviço
	private static final String ENDPOINT = "api/medico";

	
	
	
	
	// metodo para realizar insert(Post)
	@ApiOperation("Serviço para cadastro de Medico") //Notação de Swagger para cadastro
	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
	@CrossOrigin
	
	
	public ResponseEntity<String> post(@RequestBody MedicoPostRequest request) { // post envia dados
		try {
			Medico medico = new Medico();
			// request.getNome() pega od dados da tela medicoPostRequest
			// medico.setNome coloca dentro do medico medico
			medico.setNome(request.getNome());
			medico.setCrm(request.getCrm());
			medico.setTelefone(request.getTelefone());
			medico.setTipo(request.getTipo());
			
			
			repository.save(medico);

			return ResponseEntity.status(HttpStatus.OK).body("Medico cadastrado"); //Notação do Swagger de resposta

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro" + e.getMessage());
		}
	}

	
	
	
	
	// metodo para realizar update(Put)
	@ApiOperation("Serviço para atualização dos dados de um Medico") //Notação de Swagger para update
	@RequestMapping(value = ENDPOINT, method = RequestMethod.PUT)
	@CrossOrigin
	public ResponseEntity<String> put(@RequestBody MedicoPutRequest request) { // put atualiza dados
		try {
			 //inf da tela
			Optional<Medico> item = repository.findById(request.getIdMedico());
			
			//verificar medico nao foi encontrado
			if(item.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Medico não encontrado");
			} else {
				
				Medico medico = item.get();
				
				medico.setNome(request.getNome());
				medico.setCrm(request.getCrm());
				medico.setTelefone(request.getTelefone());
				medico.setTipo(request.getTipo());
				
								
				repository.save(medico);
				
				return ResponseEntity.status(HttpStatus.OK).body("Atualizado");
			}
 			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro :" + e.getMessage());
		}
		
	}

	
	
	
	
	// metodo para realizar delete, recebe um id
	@ApiOperation("Serviço para deletar Medico") //Notação de Swagger para deletar
	@RequestMapping(value = ENDPOINT + "/{idmedico}", method = RequestMethod.DELETE)
	@CrossOrigin
	public ResponseEntity<String> delete(@PathVariable("idmedico") Integer idmedico) { // delete deleta dados
		try {// busca medico no banco
			Optional<Medico> item = repository.findById(idmedico);
			
			if (item.isEmpty()) { //verificar se lista esta vazia
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Medico não encontrado");
			
			} else {
				Medico medico = item.get();
				repository.delete(medico);
				return ResponseEntity.status(HttpStatus.OK).body("Medico excluido");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro :" + e.getMessage());
		}

	}

	
	
	// metodo para realizar get
	@ApiOperation("Serviço para consultar todos os Medicos") //Notação de Swagger para get
	@RequestMapping(value = ENDPOINT, method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<List<MedicoGetResponse>> get() { // get busca dados

		List<MedicoGetResponse> response = new ArrayList<MedicoGetResponse>();
		
		for (Medico medico : repository.findAll()) { // pegando os itens que estao em medico Banco
			
			MedicoGetResponse item = new MedicoGetResponse();

			item.setIdMedico(medico.getIdmedico());
			item.setNome(medico.getNome());
			item.setCrm(medico.getCrm());
			item.setTelefone(medico.getTelefone());
			item.setTipo(medico.getTipo());
			

			response.add(item);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}


	
	
	// buscar por id, recebe um id
	@ApiOperation("Serviço para consultar todos os Medicos") //Notação de Swagger para get
	@RequestMapping(value = ENDPOINT + "/{idmedico}", method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<MedicoGetResponse> getId(@PathVariable("idmedico") Integer idmedico) { // get id busca dados
		Optional<Medico> item = repository.findById(idmedico); // Optional para nao tratar execao

		if (item.isEmpty()) { // verificando se esta vazio
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			MedicoGetResponse response = new MedicoGetResponse();
			
			Medico medico = item.get();

			response.setIdMedico(medico.getIdmedico());
			response.setNome(medico.getNome());
			response.setCrm(medico.getCrm());
			response.setTelefone(medico.getTelefone());
			response.setTipo(medico.getTipo());
			

			return ResponseEntity.status(HttpStatus.OK).body(response);
		}

	}
}
