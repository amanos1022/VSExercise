package com.vinoshipper.exercise.api

class SuccessApiResponse<T>(data:T) : ApiResponse<T> {
    override val status = ResponseStatus.OK
    override var data = data
}