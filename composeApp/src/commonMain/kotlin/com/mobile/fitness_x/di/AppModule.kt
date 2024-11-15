package com.mobile.fitness_x.di

import com.mobile.fitness_x.screen.articles.ArticlesViewModel
import com.mobile.fitness_x.screen.home.HomeViewModel
import com.mobile.fitness_x.screen.profile.ProfileViewModel
import com.mobile.fitness_x.screen.setting.SettingViewModel
import com.mobile.fitness_x.screen.workout.WorkOutViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { ArticlesViewModel() }
    viewModel { WorkOutViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { SettingViewModel(get(), get()) }
}