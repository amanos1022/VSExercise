package com.vinoshipper.exercise.hoursDiff

import com.vinoshipper.exercise.api.hoursDiff.hoursDiff
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class HoursDiffTests {
    @Test
    fun success_tests(){
        val diff1 = hoursDiff(
            LocalDateTime.parse("2021-12-09T16:00:00"),
            LocalDateTime.parse("2021-12-11T20:00:00"),
        )

        assert(diff1 == 9L)

        val diff2 = hoursDiff(
            LocalDateTime.parse("2021-01-01T06:00:00"),
            LocalDateTime.parse("2021-12-31T20:00:00"),
        )

        assert(diff2 == 2088L)

        val diff3 = hoursDiff(
            LocalDateTime.parse("2021-01-01T06:00:00"),
            LocalDateTime.parse("2021-02-28T12:00:00"),
        )

        assert(diff3 == 328L)
    }
}