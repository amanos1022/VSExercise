package com.vinoshipper.exercise.api.hoursDiff

import java.time.LocalDate
import java.time.LocalDateTime


fun hoursDiff(dateTime1: LocalDateTime, dateTime2: LocalDateTime): Long {
    val numWeekdays : Long = getWeekDays(
        LocalDate.of(dateTime1.year, dateTime1.monthValue, dateTime1.dayOfMonth),
        LocalDate.of(dateTime2.year, dateTime2.monthValue, dateTime2.dayOfMonth),
    )

    val hoursWorkedOnStartDay = hoursWorkedInDay(dateTime1)
    val hoursLeftinEndDay = hoursLeftInDay(dateTime2)

    return (numWeekdays * 8) - hoursWorkedOnStartDay + hoursLeftinEndDay
}