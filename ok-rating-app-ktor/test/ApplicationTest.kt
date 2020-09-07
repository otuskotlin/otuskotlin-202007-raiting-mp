package ru.otus.otuskotlin.user

import io.ktor.http.*
import io.ktor.server.testing.*
import io.ktor.utils.io.charsets.Charsets
import kotlinx.serialization.json.Json
import ru.otus.otuskotlin.rating.module
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.fail

class ApplicationTest {
    @Test
    fun get() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/1") {
                addHeader("Content-Type", "application/json")
            }.apply {
                println(response.content)
                assertEquals(HttpStatusCode.OK, response.status())
                assertTrue {
                    response.content?.contains("\"id\" : \"1\"") ?: false
                }
            }
        }
    }

    @Test
    fun index() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Post, "/items/") {
                addHeader("Content-Type", "application/json")
                setBody("""
                    {
                      "offset": 10,
                      "limit": 10,
                      "filter": {
                        "searchString": "test"
                      }
                    }  
                """.trimIndent())
            }.apply {
                println(response.content)
                assertEquals(HttpStatusCode.OK, response.status())
                assertTrue {
                    response.content?.contains("\"limit\" : 10") ?: false
                }
            }
        }
    }

    @Test
    fun create() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Post, "/") {
                addHeader("Content-Type", "application/json")
                setBody("""
{
  "id": "id",
  "externalObjectId": "externalObjectId",
  "externalTypeId": "externalTypeId",
  "rating": "rating",
  "createdBy": "createdBy",
  "createdAt": "2020-09-03"
}
                """.trimIndent())
            }.apply {
                println(response.content)
                assertEquals(HttpStatusCode.OK, response.status())
                assertTrue {
                    response.content?.contains("\"id\" : \"id\"") ?: false
                }
            }
        }
    }

    @Test
    fun delete() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Delete, "/") {
                addHeader("Content-Type", "application/json")
                setBody("""
{
  "id": "1"
}
                """.trimIndent())
            }.apply {
                println(response.content)
                assertEquals(HttpStatusCode.OK, response.status())
                assertTrue {
                    response.content?.contains("\"id\" : \"1\"") ?: false
                }
            }
        }
    }

}
