package io.github.keep2iron.daydream

import io.github.keep2iron.daydream.entity.Movie
import io.github.keep2iron.daydream.repository.MovieRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class MovieTests {

    @Autowired
    lateinit var movieRepository: MovieRepository

    @Test
    fun testMovieAdd(){
        val movie = Movie(
                movieName = "天气之子",
                movieCover = "/static/cover/weathering_with_you.jpg",
                year = 2019
        )

        movieRepository.save(movie);
    }

}