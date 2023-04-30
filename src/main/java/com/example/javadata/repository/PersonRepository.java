package com.example.javadata.repository;


import com.example.javadata.entity.Contact;
import com.example.javadata.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class PersonRepository {
    @PersistenceContext
    EntityManager entityManager;


    public String putData(List<Contact> contacts) {
        contacts.forEach(entityManager::persist);
        return "Success";
    }

    public String getPerson(String city) {
        city = city.toLowerCase();
        List<?> persons = entityManager.createQuery("select person from Contact where LOWER(cityOfLiving)= ?1", Person.class)
                .setParameter(1, city)
                .getResultList();
        return persons.toString();
    }
}
