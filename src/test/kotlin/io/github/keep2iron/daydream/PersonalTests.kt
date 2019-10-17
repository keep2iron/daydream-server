package io.github.keep2iron.daydream

import io.github.keep2iron.daydream.repository.PersonRepository
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class PersonalTests {

    @Autowired
    lateinit var personalRepository: PersonRepository



}