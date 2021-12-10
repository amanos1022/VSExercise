package com.vinoshipper.exercise.api.bouncer

import com.vinoshipper.exercise.api.ErrorApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import java.time.format.DateTimeParseException


@ControllerAdvice("com.vinoshipper.exercise.api.bouncer")
class BouncerControllerAdvice {
    @ExceptionHandler(DateTimeParseException::class)
    @ResponseBody
    fun handleValidationExceptions(e: DateTimeParseException): ResponseEntity<ErrorApiResponse>? {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
            ErrorApiResponse("Birthday isn't properly formatted")
        )
    }
    @ExceptionHandler(FutureDateException::class)
    @ResponseBody
    fun handleValidationExceptions(e: FutureDateException): ResponseEntity<ErrorApiResponse>? {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
            ErrorApiResponse(e.message.toString())
        )
    }

    @ExceptionHandler(MissingServletRequestParameterException::class)
    @ResponseBody
    fun handleValidationExceptions(e: MissingServletRequestParameterException): ResponseEntity<ErrorApiResponse>? {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
            ErrorApiResponse(e.message.toString())
        )
    }
}