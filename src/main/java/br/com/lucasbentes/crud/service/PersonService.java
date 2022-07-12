package br.com.lucasbentes.crud.service;

import br.com.lucasbentes.crud.data.vo.v1.PersonVO;
import br.com.lucasbentes.crud.exceptions.ResourceNotFoundException;
import br.com.lucasbentes.crud.model.Person;
import br.com.lucasbentes.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<PersonVO> findAll(){
        logger.info("Finding all people!");
        return repository.findAll();
    }

    public PersonVO findById(Long id){
        logger.info("Finding one person!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person!");
        return repository.save(person);
    }

    public PersonVO update(PersonVO person) {
        logger.info("Updating one person!");

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));

        entity.setFistName(person.getFistName());
        entity.setLastName(person.getFistName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));

        repository.delete(entity);
    }

}
