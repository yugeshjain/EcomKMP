import SwiftUI
import shared

struct ContentView: View { 

	var body: some View {
        EcomAppIosComposeView().edgesIgnoringSafeArea(.top)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
