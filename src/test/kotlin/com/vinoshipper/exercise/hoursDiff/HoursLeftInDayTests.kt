package com.vinoshipper.exercise.hoursDiff

import com.vinoshipper.exercise.api.hoursDiff.hoursLeftInDay
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
}