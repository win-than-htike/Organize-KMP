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
    
    var body: some View {
        List {
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
        }
    }
    
}

private struct RowItem: Hashable {
    let title: String
    let subtitle: String
}

#Preview {
    AboutListView(items: [AboutViewModel.RowItem(title: "Title", subtitle: "Subtitle")]
    )
}
