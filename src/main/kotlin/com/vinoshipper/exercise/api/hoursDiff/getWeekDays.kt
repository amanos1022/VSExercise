package com.vinoshipper.exercise.api.hoursDiff

import com.vinoshipper.exercise.api.bouncer.FutureDateException
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.ChronoUnit

fun getWeekDays(start: LocalDate, end: LocalDate): Long {
    if(end.isBefore(start)){
        throw FutureDateException()
    }

    val startW = start.dayOfWeek
    val endW = end.dayOfWeek
    val days = ChronoUnit.DAYS.between(start, end)
    val daysWithoutWeekends = days - 2 * ((days + startW.value) / 7)

    //adjust for starting and ending on a Sunday:
    return daysWithoutWeekends + (if (startW == DayOfWeek.SUNDAY) 1 else 0) + if (endW == DayOfWeek.SUNDAY) 1 else 0
}
