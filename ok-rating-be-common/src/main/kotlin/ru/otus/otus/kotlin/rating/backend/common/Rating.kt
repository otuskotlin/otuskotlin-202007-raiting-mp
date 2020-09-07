package ru.otus.otus.kotlin.rating.backend.common

import java.time.LocalDateTime

data class Rating(
    var id: String? = null,
    var externalObjectId: String,
    var externalTypeId: String,
    var rating: String,
    var createdBy: String,
    var createdAt: LocalDateTime,
    var updatedAt: LocalDateTime? = null
)