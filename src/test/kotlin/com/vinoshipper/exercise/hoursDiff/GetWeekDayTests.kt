package com.vinoshipper.exercise.hoursDiff

import com.vinoshipper.exercise.api.bouncer.FutureDateException
import com.vinoshipper.exercise.api.bouncer.bouncer
import com.vinoshipper.exercise.api.hoursDiff.getWeekDays
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeParseException

@SpringBootTest
class GetWeekDayTests {
    @Test
    fun failed_input() {
        val endBeforeStart: () -> Unit = { getWeekDays(LocalDate.now(), LocalDate.parse("2020-01-01")) }

        // TODO: Make separate exception for this!
        assertThrows<FutureDateException>(endBeforeStart)
    }

    @Test
    fun manual_solutions() {
        assert(getWeekDays(LocalDate.now(), LocalDate.now()) == 0L);
        assert(getWeekDays(LocalDate.parse("2021-12-09"), LocalDate.parse("2021-12-12")) == 2L);
        assert(getWeekDays(LocalDate.parse("2021-12-09"), LocalDate.parse("2021-12-25")) == 12L);
    }
}