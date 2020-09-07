package ru.otus.otuskotlin.rating.backend.app.spring

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath


@SpringBootTest
@AutoConfigureMockMvc
internal class RatingControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun get() {
        mockMvc.perform(get("/1"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(jsonPath("$.data.id").value("1"))
    }

    @Test
    fun index() {
        mockMvc.perform(
            post("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """
{
  "offset": 10,
  "limit": 10,
  "filter": {
    "searchString": "test"
  }
}  
            """.trimIndent()
                )
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(jsonPath("$.data[0].id").value("id"))
            .andExpect(jsonPath("$.limit").value("10"))
    }

    @Test
    fun create() {
        mockMvc.perform(
            post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """
{
  "id": "id",
  "externalObjectId": "externalObjectId",
  "externalTypeId": "externalTypeId",
  "rating": "rating",
  "createdBy": "createdBy",
  "createdAt": "2020-09-03"
}
            """.trimIndent()
                )
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(jsonPath("$.data.id").value("id"))
            .andExpect(jsonPath("$.data.externalObjectId").value("externalObjectId"))
    }

    @Test
    fun delete() {
        mockMvc.perform(
            delete("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """
{
  "id": "1"
}
            """.trimIndent()
                )
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(jsonPath("$.data.id").value("1"))
            .andExpect(jsonPath("$.data.externalObjectId").value("externalObjectId"))
    }
}