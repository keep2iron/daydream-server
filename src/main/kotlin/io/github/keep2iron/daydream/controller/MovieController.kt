package io.github.keep2iron.daydream.controller

import io.github.keep2iron.daydream.core.APIController
import io.github.keep2iron.daydream.entity.dto.BaseResponse
import io.github.keep2iron.daydream.entity.Movie
import io.github.keep2iron.daydream.repository.MovieRepository
import io.github.keep2iron.daydream.util.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import kotlin.streams.toList

@RestController
@APIController
class MovieController {

    @Autowired
    lateinit var repository: MovieRepository

    @RequestMapping(path = ["/movie/recommendMovies"], method = [RequestMethod.POST, RequestMethod.GET])
    fun queryRecommendMovies(@RequestParam("page", defaultValue = Constants.PAGE_DEFAULT) page: Int,
                             @RequestParam("size", defaultValue = Constants.PAGE_SIZE) size: Int): BaseResponse<List<Movie>> {
        val pageRequest = PageRequest.of(page, size)
        val results = repository.findAll(pageRequest)

        val convertList = results.get().map {
            it.copy(movieCover = "${Constants.HOST}${it.movieCover}")
        }

        return BaseResponse(value = convertList.toList())
    }

}