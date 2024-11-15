package database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.mobile.fitness_x.db.FitnessXDatabase

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            schema = FitnessXDatabase.Schema,
            name = "FitnessXDatabase.db"
        )
    }

}