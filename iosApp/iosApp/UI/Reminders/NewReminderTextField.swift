//
//  NewReminderTextField.swift
//  iosApp
//
//  Created by Win Than Htike on 15/2/2567 BE.
//  Copyright © 2567 BE orgName. All rights reserved.
//

import SwiftUI

struct NewReminderTextField: View {
  @Binding var text: String
  var onSubmit: () -> Void

  var body: some View {
    TextField(
      "Add new reminder here",
      text: $text
    ).onSubmit {
      onSubmit()
    }
  }
}

struct NewReminderTextField_Previews: PreviewProvider {
  static var previews: some View {
    NewReminderTextField(text: .constant("")) {
    }
  }
}
