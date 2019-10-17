package io.github.keep2iron.daydream.repository

import io.github.keep2iron.daydream.entity.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person,Int> {



}