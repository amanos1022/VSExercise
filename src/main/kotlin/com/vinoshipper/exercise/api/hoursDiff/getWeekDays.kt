package com.vinoshipper.exercise.api.hoursDiff

import com.vinoshipper.exercise.api.bouncer.FutureDateException
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.ChronoUnit

fun getWeekDays(start: LocalDate, end: LocalDate): Long {
    if(end.isBefore(start)){
        throw FutureDateException()
    }

    if(start == end){
        if(start.dayOfWeek != DayOfWeek.SUNDAY && start.dayOfWeek != DayOfWeek.SATURDAY){
            return 1
        }

        return 0
    }

    val startW = start.dayOfWeek
    val endW = end.dayOfWeek
    val days = ChronoUnit.DAYS.between(start.minusDays(1), end)
    var daysWithoutWeekends = (days - 2 * ((days + startW.value) / 7))

    if(startW == DayOfWeek.SUNDAY){
        daysWithoutWeekends += 1
    }

    if(endW == DayOfWeek.SATURDAY){
        daysWithoutWeekends += 1
    }

    return daysWithoutWeekends
    //adjust for starting and ending on a Sunday:
//    return daysWithoutWeekends + (if (startW == DayOfWeek.SUNDAY) 1 else 0) + if (endW == DayOfWeek.SUNDAY) 1 else 0
}
