package com.vinoshipper.exercise.api.hoursDiff

import java.time.LocalDateTime

fun hoursWorkedInDay(day: LocalDateTime) : Int {
    if(day.hour >= 17){
        return 8;
    }

    if(day.hour <= 9){
        return 0;
    }

    return day.hour - 9
}