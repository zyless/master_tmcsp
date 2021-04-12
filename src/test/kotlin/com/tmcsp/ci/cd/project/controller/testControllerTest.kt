package com.tmcsp.ci.cd.project.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.tmcsp.ci.cd.project.entity.Person
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

@WebMvcTest
internal class testControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun returnText() {
        val request = MockMvcRequestBuilders.get("/test/text")
        val result = mockMvc.perform(request).andReturn();
        assertEquals("Hello World", result.getResponse().getContentAsString())
    }

    @Test
    fun returnNumber() {
        val request = MockMvcRequestBuilders.get("/test/number")
        val result = mockMvc.perform(request).andReturn();
        assertTrue(result.getResponse().getContentAsString().toInt() > 4)

    }

    @Test
    fun returnObject() {
        val request = MockMvcRequestBuilders.get("/test/object")
        val result = mockMvc.perform(request).andReturn();
        val json = result.getResponse().getContentAsByteArray()
        val person = ObjectMapper().readValue(json, Person::class.java)
        assertTrue(person is Person)
        assertTrue(person.age == 25)

    }
}