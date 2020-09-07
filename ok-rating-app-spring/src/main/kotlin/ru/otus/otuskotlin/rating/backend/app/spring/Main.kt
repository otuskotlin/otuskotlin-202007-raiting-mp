package ru.otus.otuskotlin.rating.backend.app.spring

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
class SpringApplication: WebMvcConfigurer{
    @Autowired
    lateinit var corsResponseFilter: CORSResponseFilter

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(corsResponseFilter);
    }
}

fun main(args: Array<String>) {
    runApplication<SpringApplication>(*args)
}
