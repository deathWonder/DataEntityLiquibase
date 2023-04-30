package com.example.javadata.service;

import com.example.javadata.entity.Contact;
import com.example.javadata.entity.Person;
import com.example.javadata.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public String create() {
        Person person1 = new Person();
        person1.setPerson("Sabir", "Lord", 25);
        Person person2 = new Person();
        person2.setPerson("Sophi", "Got", 50);
        Person person3 = new Person();
        person3.setPerson("Lina", "Eat", 10);

        List<Contact> contacts = new ArrayList<>();

        contacts.add(Contact.builder()
                .person(person1)
                .phoneNumber("12345543210")
                .cityOfLiving("Moscow")
                .build());

        contacts.add(Contact.builder()
                .person(person2)
                .phoneNumber("99999999999")
                .cityOfLiving("Moscow")
                .build());

        contacts.add(Contact.builder()
                .person(person3)
                .phoneNumber("66666666666")
                .cityOfLiving("Moscow")
                .build());

        return repository.putData(contacts);
    }

    public String getPersonsByCity(String city) {
        return repository.getPerson(city);
    }
}
