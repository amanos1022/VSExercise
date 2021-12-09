package com.vinoshipper.exercise.api.bouncer

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun bouncer(nowDate: LocalDate, bday: String) : Boolean {
    val formatter = DateTimeFormatter
                        .ofPattern("yyyy-MM-dd" )

    val bdayDate : LocalDate = LocalDate.parse(bday, formatter)

    if(nowDate.isBefore(bdayDate)){
        throw FutureDateException()
    }

    val dateDiff : Period = Period.between(nowDate, bdayDate)

    return dateDiff.years <= -21
}