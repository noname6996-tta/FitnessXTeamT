package di

import org.koin.dsl.module
import usecase.ChangeThemeModeUseCase
import usecase.GetThemeUseCase

val domainModule = module {
    factory { ChangeThemeModeUseCase(get()) }
    factory { GetThemeUseCase(get()) }
}