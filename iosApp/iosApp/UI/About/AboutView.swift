//
//  AboutView.swift
//  iosApp
//
//  Created by Win Than Htike on 14/2/2567 BE.
//  Copyright © 2567 BE orgName. All rights reserved.
//

import SwiftUI
import shared

struct AboutView: View {
    @Environment(\.dismiss)
    private var dismiss
    
    @State private var viewModel = AboutViewModel()
    
    var body: some View {
        NavigationStack {
            AboutListView(items: viewModel.items)
                .navigationTitle("About Device")
                .toolbar {
                    ToolbarItem(placement: .primaryAction) {
                        Button {
                            dismiss()
                        } label: {
                            Text("Done")
                                .bold()
                        }
                    }
                }
        }
    }
}

struct AboutView_Previews: PreviewProvider {
    static var previews: some View {
        AboutView()
    }
}
