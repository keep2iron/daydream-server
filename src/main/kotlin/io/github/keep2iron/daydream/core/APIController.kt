package io.github.keep2iron.daydream.core

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
@RequestMapping("/api")
annotation class APIController(@get:AliasFor(annotation = Component::class) val value: String = "")