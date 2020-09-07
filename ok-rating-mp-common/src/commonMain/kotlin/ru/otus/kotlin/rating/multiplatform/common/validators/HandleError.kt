package ru.otus.kotlin.rating.multiplatform.common.validators

import kotlin.jvm.JvmOverloads

data class HandleError @JvmOverloads constructor(
    val field: String = "",
    val message: String = ""
)