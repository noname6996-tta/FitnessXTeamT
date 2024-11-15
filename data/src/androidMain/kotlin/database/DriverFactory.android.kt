package database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.mobile.fitness_x.db.FitnessXDatabase

actual class DriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = FitnessXDatabase.Schema,
            context = context,
            name = "FitnessXDatabase.db"
        )
    }

}