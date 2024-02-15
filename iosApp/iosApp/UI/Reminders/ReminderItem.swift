//
//  ReminderItem.swift
//  iosApp
//
//  Created by Win Than Htike on 15/2/2567 BE.
//  Copyright © 2567 BE orgName. All rights reserved.
//

import SwiftUI

struct ReminderItem: View {
  let title: String
  let isCompleted: Bool

  var body: some View {
    HStack {
      Image(
        systemName: isCompleted ? "largecircle.fill.circle" : "circle"
      )
      .imageScale(.large)
      .foregroundStyle(
        isCompleted ? AnyShapeStyle(.tint) : AnyShapeStyle(.secondary)
      )
      Text(title)
        .font(.body)
        .strikethrough(isCompleted, color: nil)
        .foregroundStyle(
          isCompleted ? .secondary : .primary
        )
      Spacer()
    }
    .contentShape(Rectangle())
  }
}

struct ReminderItem_Previews: PreviewProvider {
  static var previews: some View {
    Group {
      ReminderItem(title: "New Item", isCompleted: false)
      ReminderItem(title: "Done Item", isCompleted: true)
    }
  }
}
