//
//  RemindersViewModelWrapper.swift
//  iosApp
//
//  Created by Win Than Htike on 15/2/2567 BE.
//  Copyright © 2567 BE orgName. All rights reserved.
//

import Observation
import shared

@Observable
final class RemindersViewModelWrapper {
    
    let viewModel : ReminderViewModel = Koin.instance.get()
    
    private(set) var reminders: [Reminder] = []
    
    init() {
        viewModel.onRemindersUpdated = { [weak self] items in
            self?.reminders = items
        }
    }
    
    
    
}
