package com.vinoshipper.exercise.bouncer;

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.http.MediaType;


@AutoConfigureMockMvc
@SpringBootTest
class BouncerControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    @Throws(Exception::class)
    fun test_no_params() {
        mockMvc.perform(
                get("/bouncer")
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().is4xxClientError())
    }

    @Test
    fun test_works() {
        mockMvc.perform(
            get("/bouncer?bday=2000-01-01")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
    }
}
