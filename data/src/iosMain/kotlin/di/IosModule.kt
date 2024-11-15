package di

import app.cash.sqldelight.db.SqlDriver
import database.DriverFactory
import org.koin.dsl.module

val driverModule = module {
    single<SqlDriver> { DriverFactory().createDriver() }
}

val iOsDataModule = listOf(driverModule)