package ru.otus.kotlin.rating.multiplatform.transport.models

import kotlinx.serialization.Serializable

@Serializable
data class KmpRatingIndex(
    var limit: Long? = null,
    var offset: Long? = null,
    var filter: Filter? = null
) {
    @Serializable
    data class Filter(
        var searchString: String? = null
    )
}
