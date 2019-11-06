package io.github.keep2iron.daydream.controller

import io.github.keep2iron.daydream.core.APIController
import io.github.keep2iron.daydream.entity.dto.BaseResponse
import io.github.keep2iron.daydream.entity.pojo.Movie
import io.github.keep2iron.daydream.entity.dto.RecommendItem
import io.github.keep2iron.daydream.entity.dto.RecommendMovieCollection
import io.github.keep2iron.daydream.entity.pojo.MovieCover
import io.github.keep2iron.daydream.repository.MovieCoverRepository
import io.github.keep2iron.daydream.repository.MovieRepository
import io.github.keep2iron.daydream.util.BusinessError
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
    lateinit var movieRepository: MovieRepository

    @Autowired
    lateinit var movieCoverRepository: MovieCoverRepository

    /**
     * 热门电影
     */
    @RequestMapping(path = ["/movie/hotMovies"], method = [RequestMethod.POST, RequestMethod.GET])
    fun queryHotMovies(@RequestParam("page", defaultValue = Constants.PAGE_DEFAULT) page: Int,
                       @RequestParam("size", defaultValue = Constants.PAGE_SIZE) size: Int): BaseResponse<List<Movie>> {
        val pageRequest = PageRequest.of(page, size)
        val results = movieRepository.findAll(pageRequest)

        val convertList = results.get().map {
            it.copy(movieCover = "${Constants.HOST}${it.movieCover}")
        }

        return BaseResponse(value = convertList.toList())
    }

    /**
     * 推荐列表
     */
    @RequestMapping(path = ["/movie/recommendMovies"], method = [RequestMethod.POST, RequestMethod.GET])
    fun queryRecommendMovies(@RequestParam("page", defaultValue = Constants.PAGE_DEFAULT) page: Int,
                             @RequestParam("size", defaultValue = Constants.PAGE_SIZE) size: Int): BaseResponse<List<RecommendItem>> {

        val result = movieRepository.findAll(PageRequest.of(0, Constants.PAGE_SIZE.toInt()))
        val movies = result.get().toList()
        val firstMovie = movies.first()

        val recommendList = mutableListOf<RecommendItem>()
        for (i in 0 until size) {
            recommendList.add(if (Math.random() < 1) {
                //推荐电影
                RecommendItem(
                        recommendItemType = RecommendItem.RECOMMEND_MOVIE,
                        recommendMovie = firstMovie.copy(
                                movieCover = "${Constants.HOST}${firstMovie.movieCover}",
                                movieCovers = listOf(
//                                        MovieCover(0, movieCoverPath = "${Constants.HOST}${firstMovie.movieCover}"),
//                                        MovieCover(0, movieCoverPath = "${Constants.HOST}${firstMovie.movieCover}")
                                        MovieCover(0, movieCoverPath = "http://img.sccnn.com/bimg/337/34571.jpg"),
                                        MovieCover(0, movieCoverPath = "http://www.leawo.cn/attachment/201409/1/1723875_1409556793I3Eg.jpg")
                                )
                        )
                )
            } else {
                //推荐电影集合
                RecommendItem(
                        recommendItemType = RecommendItem.RECOMMEND_MOVIE_COLLECTION,
                        recommendMovieCollection = RecommendMovieCollection(
                                recommendCover = "${Constants.HOST}${firstMovie.movieCover}",
                                recommendMovies = movies
                        ))
            })
        }

        return BaseResponse(value = recommendList)
    }

    /**
     * 电影详情
     */
    @RequestMapping(path = ["/movie/detail"], method = [RequestMethod.POST, RequestMethod.GET])
    fun queryMovieDetail(@RequestParam("id") id: Int): BaseResponse<Map<String, Any?>?> {
        val movie = movieRepository.findById(id).orElse(null)
                ?: return BaseResponse(
                        code = BusinessError.ERROR_MOVIE_NOT_EXIT.code,
                        message = BusinessError.ERROR_MOVIE_NOT_EXIT.message,
                        value = null)

//        val covers = movieCoverRepository.findAll().filter {
//            movie.id == it.id
//        }


        return BaseResponse(value = mapOf(
                "movie" to movie.copy(movieCover = "${Constants.HOST}${movie.movieCover}")
        ))
    }

}