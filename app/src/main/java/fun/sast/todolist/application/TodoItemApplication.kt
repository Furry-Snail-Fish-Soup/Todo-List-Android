package `fun`.sast.todolist.application

import `fun`.sast.todolist.database.TodoItemDatabase
import `fun`.sast.todolist.repository.TodoItemRepository
import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class TodoItemApplication : Application() {
    val database by lazy { TodoItemDatabase.getDatabase(this) }
    val repository by lazy { TodoItemRepository(database.TodoItemDao()) }

    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Empty implementation, because the schema isn't changing.
        }
    }

    val db = Room.databaseBuilder(
        applicationContext,
        TodoItemDatabase::class.java, "todo_item_database"
    ).addMigrations(MIGRATION_1_2).build()

}