package di

import com.mobile.fitness_x.db.FitnessXDatabase
import datastore.dataStorePreferences
import org.koin.dsl.module
import preferences.AppPreferences
import preferences.AppPreferencesImpl
import repository.Repository
import repository.RepositoryImpl

val localModule = module {
    single<FitnessXDatabase> { FitnessXDatabase(get()) }
    single<Repository> { RepositoryImpl(get()) }
    single<AppPreferences> { AppPreferencesImpl(get()) }
    single { dataStorePreferences() }
}

val dataModule = listOf(
    localModule
)