package ru.otus.kotlin.rating.multiplatform.transport.models

import kotlinx.serialization.Serializable

@Serializable
data class KmpRatingResponseItem(
    val data: KmpRating? = null,
    override val status: KmpRatingResultStatus? = null
) : KmpRatingResponse(
    status = status
)
