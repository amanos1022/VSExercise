package com.vinoshipper.exercise.api.hoursDiff

import com.vinoshipper.exercise.api.SuccessApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class HoursDiffController {
    @GetMapping("hours-diff")
    @ResponseBody
    fun getHoursDiff(@RequestParam("start") start : String, @RequestParam("end") end : String) : SuccessApiResponse<HoursDiffResponse> {
        val hours = hoursDiff(
            LocalDateTime.parse(start),
            LocalDateTime.parse(end)
        )

        val res = HoursDiffResponse(
            start.toString(),
            end.toString(),
            hours
        )

        return SuccessApiResponse<HoursDiffResponse>(res)
    }

}