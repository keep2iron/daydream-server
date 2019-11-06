package io.github.keep2iron.daydream.entity.pojo

import javax.persistence.*

@Entity
@Table(name = "Directors")
data class Director(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "DirectorID")
        val id: Int = 0,

        /**
         * 导演名称
         */
        @Column(name = "DirectorName")
        val name: String = "",

        /**
         * 导演头像
         */
        @Column(name = "DirectorAvatar")
        val avatar: String = "",

        /**
         * 导演简介
         */
        @Column(name = "DirectorIntroduction")
        val introduction: String = ""


)