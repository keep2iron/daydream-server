package io.github.keep2iron.daydream.repository

import io.github.keep2iron.daydream.entity.Movie
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface MovieRepository : PagingAndSortingRepository<Movie, Int> {
}