package com.mobile.fitness_x.di

import com.mobile.fitness_x.screens.articles.ArticlesViewModel
import com.mobile.fitness_x.screens.home.HomeViewModel
import com.mobile.fitness_x.screens.login.LoginViewModel
import com.mobile.fitness_x.screens.notification.NotificationViewModel
import com.mobile.fitness_x.screens.profile.ProfileViewModel
import com.mobile.fitness_x.screens.setting.SettingViewModel
import com.mobile.fitness_x.screens.workout.WorkOutViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { ArticlesViewModel() }
    viewModel { WorkOutViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { SettingViewModel(get(), get()) }
    viewModel { LoginViewModel() }
    viewModel { NotificationViewModel() }
}