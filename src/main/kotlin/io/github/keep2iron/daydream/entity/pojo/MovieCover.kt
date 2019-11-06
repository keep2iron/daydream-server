package io.github.keep2iron.daydream.entity.pojo

import javax.persistence.*

/**
 * 电影封面
 */
@Entity
@Table(name = "MovieCovers")
data class MovieCover(

        /**
         * 封面Id
         */
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "MovieCoverID")
        val id: Int,

        /**
         * 对应的Movie
         */
        @ManyToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "MovieID")
        val movie: Movie? = null,

        /**
         * 封面路径
         */
        @Column(name = "MovieCoverPath")
        val movieCoverPath: String
)
