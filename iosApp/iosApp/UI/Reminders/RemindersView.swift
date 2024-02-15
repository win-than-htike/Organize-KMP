//
//  RemindersView.swift
//  iosApp
//
//  Created by Win Than Htike on 14/2/2567 BE.
//  Copyright © 2567 BE orgName. All rights reserved.
//

import SwiftUI

struct RemindersView: View {
  @State private var viewModelWrapper = RemindersViewModelWrapper()

  @State private var textFieldValue = ""
  @FocusState private var shouldFocusOnTextField: Bool

  var body: some View {
    List {
      if !viewModelWrapper.reminders.isEmpty {
        Section {
          ForEach(viewModelWrapper.reminders, id: \.id) { item in
            ReminderItem(title: item.title, isCompleted: item.isCompleted)
              .onTapGesture {
                withAnimation {
                  viewModelWrapper.viewModel.markReminder(id: item.id, isCompleted: !item.isCompleted)
                  shouldFocusOnTextField = false
                }
              }
          }
        }
      }

      Section {
        NewReminderTextField(text: $textFieldValue) {
          withAnimation {
            viewModelWrapper.viewModel.createReminder(
              title: textFieldValue
            )
            textFieldValue = ""
            shouldFocusOnTextField = true
          }
        }
        .focused($shouldFocusOnTextField)
      }
    }
    .navigationTitle("Reminders")
    .toolbar {
      ToolbarItemGroup(placement: .keyboard) {
        Spacer()
        Button("Done") {
          shouldFocusOnTextField = false
        }
      }
    }
  }
}

struct RemindersView_Previews: PreviewProvider {
  static var previews: some View {
    RemindersView()
  }
}
