package io.github.keep2iron.daydream.util

object Constants {

    const val HOST = "http://10.8.1.148:8080"

    const val PAGE_SIZE = "10"

    const val PAGE_DEFAULT = "0"

}

enum class BusinessError(val code: Int, val message: String) {
    ERROR_MOVIE_NOT_EXIT(501, "电影不存在")
}