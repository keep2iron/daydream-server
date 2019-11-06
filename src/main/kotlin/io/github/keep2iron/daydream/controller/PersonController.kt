package io.github.keep2iron.daydream.controller

import io.github.keep2iron.daydream.core.APIController
import io.github.keep2iron.daydream.entity.dto.BaseResponse
import io.github.keep2iron.daydream.entity.pojo.Person
import io.github.keep2iron.daydream.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@APIController
class PersonController {

    @Autowired
    lateinit var repository: PersonRepository

    @RequestMapping(path = ["/person/add"], method = [RequestMethod.GET, RequestMethod.POST])
    fun addPerson(): BaseResponse<List<Person>> {
        val person = Person()
        repository.save(person)

        val list = repository.findAll().toList()
        return BaseResponse(value = list)
    }



}