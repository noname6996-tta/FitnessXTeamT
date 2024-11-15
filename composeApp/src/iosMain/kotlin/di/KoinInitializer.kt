package di

import com.mobile.fitness_x.di.viewModelModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(iOsSharedModule + viewModelModule)
    }
}