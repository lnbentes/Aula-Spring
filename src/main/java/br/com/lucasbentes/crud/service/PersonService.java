package br.com.lucasbentes.crud.service;

import br.com.lucasbentes.crud.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();  // Simulador de ID

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id){
        logger.info("Finding one person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFistName("Lucas");
        person.setLastName("Bentes");
        person.setAddress("Rua");
        person.setGender("Male");
        return person;
    }
}
