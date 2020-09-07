package ru.otus.kotlin.rating.multiplatform.transport.models

import kotlinx.serialization.Serializable

@Serializable
data class KmpRatingResponseIndex(
    val data: List<KmpRating>? = null,
    val limit: Long? = null,
    val offset: Long? = null,
    override val status: KmpRatingResultStatus? = null
) : KmpRatingResponse(
    status = status
)
