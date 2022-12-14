package com.artemas.demo.repository

import com.artemas.demo.domain.Person
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: CrudRepository<Person, Long>
