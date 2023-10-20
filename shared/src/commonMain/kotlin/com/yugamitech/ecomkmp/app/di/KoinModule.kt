package com.yugamitech.ecomkmp.app.di

import com.yugamitech.ecomkmp.presentation.home.HomeViewModel
import org.koin.dsl.module

fun koinModule() = module {
    factory { HomeViewModel() }
}
