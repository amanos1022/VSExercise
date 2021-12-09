package com.vinoshipper.exercise.api

class ErrorApiResponse : ApiResponse<HashMap<String, String>>{
    override val status: ResponseStatus
        get() = ResponseStatus.ERROR

    override var data = HashMap<String, String>();

    constructor(msg: String){
        data["error_message"] = msg
    }
}