//
//  EcomAppIosComposeView.swift
//  iosApp
//
//  Created by Offline on 16/10/23.
//  Copyright © 2023 YugamiTech. All rights reserved.
//

import Foundation
import SwiftUI
import shared

struct EcomAppIosComposeView: UIViewControllerRepresentable {
    
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {}
    
    func makeUIViewController(context: Context) -> some UIViewController {
        EcomAppKt.EcomAppMainViewController()
    }
}
