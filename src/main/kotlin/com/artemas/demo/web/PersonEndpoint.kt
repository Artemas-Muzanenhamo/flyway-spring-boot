package com.artemas.demo.web

import com.artemas.demo.domain.Person
import com.artemas.demo.repository.PersonRepository
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PersonEndpoint(val personRepository: PersonRepository) {

    @GetMapping("/people", produces = [APPLICATION_JSON_VALUE])
    fun getAllPeople(): List<Person> {
        return personRepository.findAll().toList()
    }

    @PostMapping("/person", consumes = [APPLICATION_JSON_VALUE])
    @ResponseStatus(CREATED)
    fun addPerson(@RequestBody person: Person): Person {
        return personRepository.save(person)
    }
}
