package io.github.keep2iron.daydream.entity

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
        val year: Int = 0


)