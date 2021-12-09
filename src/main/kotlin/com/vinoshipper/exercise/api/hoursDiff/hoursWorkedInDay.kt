package com.vinoshipper.exercise.api.hoursDiff

import java.time.LocalDateTime

fun hoursLeftInDay(day: LocalDateTime) : Int {
    if(day.hour >= 17){
        return 8; // if end of day, we'll subtract all 8 hours from total time
    }

    if(day.hour <= 9){
        return 0; // don't subject any hours, because all hours of start day remain to be accounted for
    }

    return day.hour - 9;
}