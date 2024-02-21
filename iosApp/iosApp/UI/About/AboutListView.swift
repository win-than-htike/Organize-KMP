//
//  AboutListView.swift
//  iosApp
//
//  Created by Win Than Htike on 14/2/2567 BE.
//  Copyright © 2567 BE orgName. All rights reserved.
//

import SwiftUI
import shared

struct AboutListView: View {
  let items: [AboutViewModel.RowItem]
  let footer: String

  var body: some View {
    List {
      Section {
        ForEach(items, id: \.self) { item in
          VStack(alignment: .leading) {
            Text(item.title)
              .font(.footnote)
              .foregroundStyle(.secondary)
            Text(item.subtitle)
              .font(.body)
              .foregroundStyle(.primary)
          }
          .padding(.vertical, 4)
        }
      } footer: {
        Text(footer)
          .font(.caption2)
      }
    }
  }
}

#Preview {
  AboutListView(
    items: [
      AboutViewModel.RowItem(
        title: "Title",
        subtitle: "Subtitle"
      )
    ],
    footer: "Section Footer"
  )
}
