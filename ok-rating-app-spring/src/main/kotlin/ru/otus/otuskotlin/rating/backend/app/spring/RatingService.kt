package ru.otus.otuskotlin.rating.backend.app.spring

import org.springframework.stereotype.Service
import ru.otus.kotlin.rating.multiplatform.transport.models.*
import ru.otus.kotlin.rating.transport.multiplatform.backend.toKmpRating
import ru.otus.otus.kotlin.rating.backend.common.Rating
import java.time.LocalDateTime

@Service
class RatingService {
    private val ratingStub = Rating(
        id = "id",
        externalObjectId = "externalObjectId",
        externalTypeId = "externalTypeId",
        rating = "externalTypeId",
        createdAt = LocalDateTime.now(),
        createdBy = "createdBy"
    )

    fun get(id: String): KmpRatingResponseItem = KmpRatingResponseItem(
        data = ratingStub.toKmpRating(),
        status = KmpRatingResultStatus.SUCCESS
    ).apply {
        this.data?.id = id
    }

    fun index(query: KmpRatingIndex): KmpRatingResponseIndex =
        KmpRatingResponseIndex(
            data = listOf(ratingStub.toKmpRating()),
            status = KmpRatingResultStatus.SUCCESS,
            limit = query.limit,
            offset = query.offset
        )

    fun create(query: KmpRatingCreate): KmpRatingResponseItem =
        KmpRatingResponseItem(
            data = query.toKmpRating(),
            status = KmpRatingResultStatus.SUCCESS
        )

    fun delete(query: KmpRatingDelete): KmpRatingResponseItem = KmpRatingResponseItem(
        data = ratingStub.toKmpRating(),
        status = KmpRatingResultStatus.SUCCESS
    ).apply {
        this.data?.id = query.id
    }
}