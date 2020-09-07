package ru.otus.kotlin.rating.transport.multiplatform.backend

import ru.otus.kotlin.rating.multiplatform.transport.models.KmpRating
import ru.otus.kotlin.rating.multiplatform.transport.models.KmpRatingCreate
import ru.otus.otus.kotlin.rating.backend.common.Rating
import java.time.LocalDate
import java.time.LocalDateTime

fun KmpRatingCreate.toKmpRating(): KmpRating =
    KmpRating(
        id = this.id,
        externalObjectId = this.externalObjectId,
        externalTypeId = this.externalTypeId,
        rating = this.rating,
        createdBy = this.createdBy,
        createdAt = this.createdAt?.kmpToString(),
        updatedAt = this.createdAt?.kmpToString()
    )


fun Rating.toKmpRating(): KmpRating =
    KmpRating(
        id = this.id,
        externalObjectId = this.externalObjectId,
        externalTypeId = this.externalTypeId,
        rating = this.rating,
        createdBy = this.createdBy,
        createdAt = this.createdAt.kmpToString(),
        updatedAt = this.createdAt.kmpToString()
    )

fun KmpRating.toRating(): Rating =
    Rating(
        id = this.id,
        externalObjectId = this.externalObjectId.modelToString(),
        externalTypeId = this.externalTypeId.modelToString(),
        rating = this.rating.modelToString(),
        createdBy = this.createdBy.modelToString(),
        createdAt = this.createdAt.modelToLocalDateTime(),
        updatedAt = this.updatedAt.modelToLocalDateTime()
    )

private fun String?.modelToString() = this?.takeIf { it.isNotBlank() } ?: ""
private fun String?.modelToLocalDate() = this
    ?.takeIf { it.isNotBlank() }
    ?.let { LocalDate.parse(it) }
    ?: LocalDate.MIN

private fun String?.modelToLocalDateTime() = this
    ?.takeIf { it.isNotBlank() }
    ?.let { LocalDateTime.parse(it) }
    ?: LocalDateTime.MIN

private fun String.kmpToString() = this.takeIf { it.isNotBlank() }
private fun LocalDate.kmpToString(): String? = this.takeIf { it != LocalDate.MIN }?.toString()
private fun LocalDateTime.kmpToString(): String? = this.takeIf { it != LocalDateTime.MIN }?.toString()

