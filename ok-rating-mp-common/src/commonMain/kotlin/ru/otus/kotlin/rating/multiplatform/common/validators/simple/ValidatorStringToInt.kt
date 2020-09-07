package ru.otus.kotlin.rating.multiplatform.common.validators.simple

import ru.otus.kotlin.rating.multiplatform.common.validators.HandleError
import ru.otus.kotlin.rating.multiplatform.common.validators.ValidationResult
import ru.otus.kotlin.rating.multiplatform.common.validators.Validator

class ValidatorStringToInt(
    val field: String = ""
) : Validator<String?> {
    override fun validate(arg: String?): ValidationResult = ValidationResult(
        if (arg?.toIntOrNull() != null) {
            null
        } else
            HandleError(
                message = "Поле ${field.takeIf { it.isNotBlank() } ?: ""} не число",
                field = this.field
            )
    )
}
