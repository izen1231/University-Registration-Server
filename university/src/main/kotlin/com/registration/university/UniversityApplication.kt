package com.registration.university

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2

class UniversityApplication

fun main(args: Array<String>) {
	runApplication<UniversityApplication>(*args)
}