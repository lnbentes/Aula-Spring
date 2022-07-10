package br.com.lucasbentes.crud.service;

import br.com.lucasbentes.crud.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();  // Simulador de ID

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll(){
        logger.info("Finding all people!");
        List<Person> persons = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

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

    public Person create(Person person) {
        logger.info("Creating one person!");
        person.setId(counter.incrementAndGet());
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating one person!");
        person.setId(counter.incrementAndGet());
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one person!");
    }

    //######################################

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFistName("FistName:" + i);
        person.setLastName("LastName:" + i);
        person.setAddress("Address: Rua");
        person.setGender(gender());
        return person;
    }

    public String gender(){
        Double numero = Math.random() * 100;
        if(numero < 50) return "male";
        return "female";
    }
}
