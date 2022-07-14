package br.com.lucasbentes.crud.controller;

import br.com.lucasbentes.crud.data.vo.v1.PersonVO;
import br.com.lucasbentes.crud.data.vo.v2.PersonVO2;
import br.com.lucasbentes.crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO findById(@PathVariable(value = "id") Long id){
		return service.findById(id);
	}
	@GetMapping(value = "/all",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVO> findAll(){
		return service.findAll();
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO create(@RequestBody PersonVO person){
		return service.create(person);
	}

	@PostMapping(value = "/v2",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO2 createV2(@RequestBody PersonVO2 person){
		return service.createV2(person);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO update(@RequestBody PersonVO person){
		return service.update(person);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}


}
