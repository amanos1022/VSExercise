package com.vinoshipper.exercise.api

interface ApiResponse<T> {
    val status: ResponseStatus
    var data : T
}