package com.tmcsp.ci.cd.project.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity

import com.tmcsp.ci.cd.project.entity.Person

import org.springframework.web.bind.annotation.GetMapping

@RestController
@RequestMapping("/test")
class testController {


    @GetMapping("/text")
    fun returnText(): String {
        val helloWorld = "Hello World"
        return helloWorld
    }


    @GetMapping("/number")
    fun returnNumber(): Int {
        val number = 5
        return number
    }


    @GetMapping("/object")
    fun returnObject(): ResponseEntity<Person?>? {
        val person = Person("Patrik", "Abraham", 25)
        return ResponseEntity.ok(person)
    }

}