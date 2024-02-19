package com.winthan.organize.presentation

import com.winthan.organize.presentation.ReminderViewModel
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class ReminderViewModelTest {

    private lateinit var viewModel: ReminderViewModel

    @BeforeTest
    fun setup() {
        viewModel = ReminderViewModel()
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