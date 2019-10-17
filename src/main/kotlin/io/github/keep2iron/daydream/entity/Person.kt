package io.github.keep2iron.daydream.entity

import javax.persistence.*

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Persons")
data class Person(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "PersonID")
        val id: Int = 0,

        /**
         * 昵称
         */
        @Column(name = "NickName")
        val nickName: String = "",

        /**
         * 头像
         */
        @Column(name = "Avatar")
        var avatar: String = ""

)
