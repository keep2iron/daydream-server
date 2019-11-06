package io.github.keep2iron.daydream.entity.pojo

import io.github.keep2iron.daydream.entity.pojo.MovieCover
import io.github.keep2iron.daydream.entity.pojo.MovieTag
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "Movies")
data class Movie(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "MovieID")
        val id: Int = 0,

        /**
         * 电影名称
         */
        @Column(name = "MovieName")
        val movieName: String = "",

        /**
         * 电影路径
         */
        @Column(name = "MoviePath")
        val moviePath: String = "",

        /**
         * 电影封面 相对路径
         */
        @Column(name = "MovieCover")
        val movieCover: String = "",

        /**
         * 电影年份
         */
        @Column(name = "Year")
        val year: Int = 0,

        /**
         * 描述
         */
        @Column(name = "Description")
        val description: String?,

        /**
         * 封面
         */
        @OneToMany
        @JoinColumn(name = "MovieCoverID")
        val movieCovers: List<MovieCover>? = null,

        /**
         * 电影Tag
         */
        @OneToMany
        @JoinColumn(name = "MovieTagID")
        val movieTag: List<MovieTag>? = null


)