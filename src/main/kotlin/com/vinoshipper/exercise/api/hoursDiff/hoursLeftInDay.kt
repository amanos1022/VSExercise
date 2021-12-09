package com.vinoshipper.exercise.api.hoursDiff

import java.time.LocalDateTime

fun hoursLeftInDay(day: LocalDateTime) : Int {
    // todo: test for sunday and monday
    if(day.hour >= 17){
        return 0; // if end of day, we've worked all hours, keep em in
    }

    if(day.hour <= 9){
        return 8; // if begining of day, we haven't worked so remove all 8 hours
    }

    return 17 - day.hour;
}