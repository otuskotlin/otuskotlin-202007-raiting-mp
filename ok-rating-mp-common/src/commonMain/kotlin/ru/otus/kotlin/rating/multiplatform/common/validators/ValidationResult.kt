package ru.otus.kotlin.rating.multiplatform.common.validators

import kotlin.jvm.*


data class ValidationResult
@JvmOverloads
constructor(
    val errors: List<HandleError> = emptyList()
) {

    constructor(vararg argErrors: HandleError?) : this(errors = argErrors.filterNotNull())

    val isOk
        get() = errors.isEmpty()

    companion object {
        @JvmStatic
        @get:JvmName("getSUCCESS")
        val SUCCESS = ValidationResult()

        @JvmField
        val OK = SUCCESS
    }
}
