package com.vinoshipper.exercise.hoursDiff

import com.vinoshipper.exercise.api.hoursDiff.hoursLeftInDay
import com.vinoshipper.exercise.api.hoursDiff.hoursWorkedInDay
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class HoursLeftInDayTests {
    @Test
    fun test_known_success() {
        assert(hoursLeftInDay(LocalDateTime.parse("2021-12-09T16:00:00")) == 1)
        assert(hoursLeftInDay(LocalDateTime.parse("2021-12-09T18:00:00")) == 0)
        assert(hoursLeftInDay(LocalDateTime.parse("2021-12-09T08:00:00")) == 8)
    }

    @Test
    fun weekends_test() {
        assert(0 == hoursLeftInDay(LocalDateTime.parse("2021-12-11T07:00:00")))
        assert(0 == hoursLeftInDay(LocalDateTime.parse("2021-12-12T07:00:00")))
    }
}