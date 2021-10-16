package com.desafioapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.desafioapi.model.Cep;
import com.desafioapi.repository.CepRepository;

@RestController
@RequestMapping("/ceps")
public class CepController {

	@Autowired
	private CepRepository cepRepository;
	
	@GetMapping(value = "listartodos")
	@ResponseBody
	public ResponseEntity<List<Cep>> listar() {
		
		List<Cep> ceps = cepRepository.findAll();
		
		return new ResponseEntity<List<Cep>>(ceps, HttpStatus.OK);
	}
	
	@PostMapping(value = "cadastrar")
	@ResponseBody
	public ResponseEntity<Cep> salvar(@RequestBody Cep cep) {
		
		Cep returnedCep = cepRepository.save(cep);
		
		return new ResponseEntity<Cep>(returnedCep, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "exibirloja")
	@ResponseBody
	public ResponseEntity<String> exibirLoja(@RequestParam String numeroCep) {
		
		List<Cep> ceps = cepRepository.findAll();
		
		for (Cep cep : ceps) {
			int numCep = Integer.parseInt(numeroCep);
			int inicio = Integer.parseInt(cep.getFaixa_inicio());
			int fim = Integer.parseInt(cep.getFaixa_fim());
			
			if (numCep >= inicio && numCep <= fim) {
				return new ResponseEntity<String>(cep.getCodigo_loja(), HttpStatus.OK);
			}
		}
		
		String msg = "CEP não encontrado";
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizarCep(@RequestBody Cep cep) {
		
		if (cep.getId() == null) {
			return new ResponseEntity<String>("Nenhum id informado!", HttpStatus.OK);
		}
		
		Cep returnedCep = cepRepository.saveAndFlush(cep);
		
		return new ResponseEntity<Cep>(returnedCep, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "deletar")
	@ResponseBody
	public ResponseEntity<String> deletar(@RequestParam Long id) {
		
		cepRepository.deleteById(id);
		
		return new ResponseEntity<String>("CEP deletado com sucesso!", HttpStatus.OK);
	}
}
