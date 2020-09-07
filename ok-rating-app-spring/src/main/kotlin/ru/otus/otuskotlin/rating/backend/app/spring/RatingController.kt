package ru.otus.otuskotlin.rating.backend.app.spring

import org.springframework.web.bind.annotation.*
import ru.otus.kotlin.rating.multiplatform.transport.models.*

@RestController
class RatingController {

    private val service = RatingService()

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: String): KmpRatingResponseItem = service.get(id)

    @PostMapping("/items")
    fun index(@RequestBody query: KmpRatingIndex): KmpRatingResponseIndex = service.index(query)

    @PostMapping("/")
    fun create(@RequestBody query: KmpRatingCreate): KmpRatingResponseItem = service.create(query)

    @DeleteMapping("/")
    fun delete(@RequestBody query: KmpRatingDelete): KmpRatingResponseItem = service.delete(query)
}
