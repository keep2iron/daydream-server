package io.github.keep2iron.daydream.entity.pojo

import javax.persistence.*

/**
 * 电影标签
 */
@Entity
@Table(name = "MovieTags")
data class MovieTag(

        /**
         * 标签Id
         */
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "MovieTagID")
        val id: Int,

        /**
         * 标签名
         */
        @Column(name = "TagName")
        val tagName: String
)