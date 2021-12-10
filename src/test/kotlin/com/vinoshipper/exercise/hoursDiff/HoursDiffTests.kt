package com.vinoshipper.exercise.hoursDiff

import com.vinoshipper.exercise.api.bouncer.bouncer
import com.vinoshipper.exercise.api.hoursDiff.hoursDiff
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import java.time.LocalDateTime

@SpringBootTest
class HoursDiffTests {

    @Test
    fun today_and_tomorrow_middle_of_day_test() {
        val diff1 = hoursDiff(
            LocalDateTime.parse("2021-12-09T16:00:00"),
            LocalDateTime.parse("2021-12-11T20:00:00"),
        )

        assert(diff1 == 9L)
    }
    @Test
    fun entire_year_test() {


        val diff2 = hoursDiff(
            LocalDateTime.parse("2021-01-01T06:00:00"),
            LocalDateTime.parse("2021-12-31T20:00:00"),
        )

        assert(diff2 == 2088L)
    }

    @Test
    fun random_span_test() {
        val diff3 = hoursDiff(
            LocalDateTime.parse("2021-01-01T06:00:00"),
            LocalDateTime.parse("2021-02-28T12:00:00"),
        )

        assert(diff3 == 328L)
    }
}