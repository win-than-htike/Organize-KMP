package com.winthan.organize.presentation

import com.winthan.organize.initKoin
import com.winthan.organize.presentation.ReminderViewModel
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class ReminderViewModelTest : KoinTest {

    private val viewModel: ReminderViewModel by inject()

    @BeforeTest
    fun setup() {
        initKoin()
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun testCreatingReminder() {
        val title = "New Title"

        viewModel.createReminder(title)

        val count = viewModel.reminders.count {
            it.title == title
        }

        assertTrue(
            actual = count == 1,
            message = "Reminder with title: $title wasn't created."
        )
    }

}