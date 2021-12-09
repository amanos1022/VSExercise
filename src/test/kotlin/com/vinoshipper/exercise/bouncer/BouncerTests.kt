package com.vinoshipper.exercise.bouncer

import com.vinoshipper.exercise.api.bouncer.FutureDateException
import com.vinoshipper.exercise.api.bouncer.bouncer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import java.time.format.DateTimeParseException

@SpringBootTest
class BouncerTests {
    @Test
    fun bad_birthday_throws_exception() {
        val badString: () -> Unit = { bouncer(LocalDate.now(), "asdf") }

        assertThrows<DateTimeParseException>(badString)

        val nonExists: () -> Unit = { bouncer(LocalDate.now(), "2021-12-32") }
        assertThrows<DateTimeParseException>(nonExists)

        val future: () -> Unit = { bouncer(LocalDate.now(), "2022-11-10") }
        assertThrows<FutureDateException>(future)
    }

    @Test
    fun good_dates() {
        assert(bouncer(LocalDate.now(), "1000-01-01"))
        assert(bouncer(LocalDate.now(), "1984-09-03"))
    }
}
