package ru.otus.otuskotlin.rating

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.jackson.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import ru.otus.kotlin.rating.multiplatform.transport.models.KmpRatingCreate
import ru.otus.kotlin.rating.multiplatform.transport.models.KmpRatingDelete
import ru.otus.kotlin.rating.multiplatform.transport.models.KmpRatingIndex

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    val service = RatingService()

    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        allowCredentials = true
        anyHost()
    }
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    routing {
        route("/") {
            get("/{id}") {
                val id = call.parameters["id"]
                if (id == null) {
                    call.respond(HttpStatusCode.BadRequest)
                } else {
                    call.respond(service.get(id))
                }
            }
            post {
                val query = call.receive<KmpRatingCreate>()
                call.respond(service.create(query))
            }
            post("/items") {
                val query = call.receive<KmpRatingIndex>()
                call.respond(service.index(query))
            }
            delete {
                val query = call.receive<KmpRatingDelete>()
                call.respond(service.delete(query))
            }
        }
    }
}

