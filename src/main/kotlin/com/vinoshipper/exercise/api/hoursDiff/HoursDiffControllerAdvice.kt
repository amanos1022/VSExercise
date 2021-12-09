package com.vinoshipper.exercise.api.hoursDiff

import com.vinoshipper.exercise.api.ErrorApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import java.time.format.DateTimeParseException


@ControllerAdvice("com.vinoshipper.exercise.api.hoursDiff")
class HoursDiffControllerAdvice {
    @ExceptionHandler(DateTimeParseException::class)
    @ResponseBody
    fun handleValidationExceptions(e: DateTimeParseException): ResponseEntity<ErrorApiResponse>? {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
            ErrorApiResponse("Start date time or end date time was not properly formatted please use ISO 8601 (e.g. yyyy-mm-ddTHH:MM:SS)")
        )
    }
}