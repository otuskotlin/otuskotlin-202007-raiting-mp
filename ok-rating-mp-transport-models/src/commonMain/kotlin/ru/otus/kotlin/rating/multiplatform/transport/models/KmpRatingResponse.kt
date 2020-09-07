package ru.otus.kotlin.rating.multiplatform.transport.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
open class KmpRatingResponse(
    @Transient open val status: KmpRatingResultStatus? = null,
    @Transient open val errors: List<KmpRatingError>? = null
)
