package com.vinoshipper.exercise.hoursDiff

import com.vinoshipper.exercise.api.hoursDiff.hoursWorkedInDay
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class HoursWorkedInDayTests {
    @Test
    fun known_success_test(){
        assert(5 == hoursWorkedInDay(LocalDateTime.parse("2021-12-09T14:00:00")))
        assert(0 == hoursWorkedInDay(LocalDateTime.parse("2021-12-09T07:00:00")))
        assert(8 == hoursWorkedInDay(LocalDateTime.parse("2021-12-09T20:00:00")))
    }
}