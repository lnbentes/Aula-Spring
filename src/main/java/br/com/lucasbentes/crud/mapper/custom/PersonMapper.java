package br.com.lucasbentes.crud.mapper.custom;

import br.com.lucasbentes.crud.data.vo.v2.PersonVO2;
import br.com.lucasbentes.crud.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVO2 convertiEntityToVo(Person person){
        PersonVO2 vo2 = new PersonVO2();
        vo2.setId(person.getId());
        vo2.setFirstName(person.getFirstName());
        vo2.setLastName(person.getLastName());
        vo2.setAddress(person.getAddress());
        vo2.setBirthday(new Date());
        return vo2;
    }

    public Person convertiVoToEntity(PersonVO2 vo2){
        Person person = new Person();
        person.setId(vo2.getId());
        person.setFirstName(vo2.getFirstName());
        person.setLastName(vo2.getLastName());
        person.setAddress(vo2.getAddress());
//        person.setBirthday(new Date());
        return person;
    }
}

