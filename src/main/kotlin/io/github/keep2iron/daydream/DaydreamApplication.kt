package io.github.keep2iron.daydream

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Controller
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration
import org.springframework.boot.web.servlet.ServletRegistrationBean



@Configuration
@SpringBootApplication(scanBasePackages = ["io.github.keep2iron.daydream.controller"])
class DaydreamApplication : WebMvcConfigurer{
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/")
    }
}

fun main(args: Array<String>) {
    runApplication<DaydreamApplication>(*args)
}