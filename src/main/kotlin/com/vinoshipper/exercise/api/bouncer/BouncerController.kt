package com.vinoshipper.exercise.api.bouncer

import com.vinoshipper.exercise.api.SuccessApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class BouncerController {
    @GetMapping("/bouncer")
    @ResponseBody
    fun isOfAge(@RequestParam("bday") bday : String) :SuccessApiResponse<BouncerResponse> {
        val isOfAge : Boolean = bouncer(LocalDate.now(), bday)
        if(isOfAge) {
            return SuccessApiResponse(BouncerResponse("You are good to go."))
        }

        return SuccessApiResponse(BouncerResponse("You are not of age."))
    }

}