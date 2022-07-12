package br.com.lucasbentes.crud.service;

import br.com.lucasbentes.crud.data.vo.v1.PersonVO;
import br.com.lucasbentes.crud.exceptions.ResourceNotFoundException;
import br.com.lucasbentes.crud.mapper.DozerMapper;
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
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class); // Retorna a lista convertida
    }

    /*
     * 1- Localiza o person armazena na variable;
     * 2- retorna o person convertido para personVO;
     * */
    public PersonVO findById(Long id){
        logger.info("Finding one person!");
        var person = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
        return DozerMapper.parseObject(person, PersonVO.class);
    }

    /*
    * 1- Pega o personVo e converte para person;
    * 2- Salva no banco, o banco retorna um person que vai ser convertido para personVO;
    * 3- Devolve o personVO;
    * */
    public PersonVO create(PersonVO person) {
        logger.info("Creating one person!");
        var entity = DozerMapper.parseObject(person, Person.class);
        var entityVO = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return entityVO;
    }

    /*
     * 1- Localiza o person armazena na variable;
     * 2- Set as informações do personVO para o person;
     * 3- Salva o person no banco e converta ele para personVO;
     * 4- Retorna o personVO;
     * */
    public PersonVO update(PersonVO person) {
        logger.info("Updating one person!");

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getFirstName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        var entityVO = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return entityVO;
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));

        repository.delete(entity);
    }

}
