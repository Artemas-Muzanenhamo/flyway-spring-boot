package com.artemas.demo.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "persons")
class Person(
    @Id
    @GeneratedValue
    val id: Long?,
    val name: String,
    val surname: String
)
