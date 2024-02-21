import SwiftUI

@main
struct iOSApp: App {
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
    
    init() {
        Koin.start()
    }
    
}
