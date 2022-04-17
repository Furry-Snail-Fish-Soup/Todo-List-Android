package `fun`.sast.todolist.application

import `fun`.sast.todolist.database.TodoCollectionDatabase
import `fun`.sast.todolist.database.TodoItemDatabase
import `fun`.sast.todolist.repository.TodoCollectionRepository
import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class TodoCollectionApplication : Application() {
    val database by lazy { TodoCollectionDatabase.getDatabase(this) }
    val repository by lazy { TodoCollectionRepository(database.TodoCollectionDao()) }

    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Empty implementation, because the schema isn't changing.
        }
    }

    val db = Room.databaseBuilder(
        applicationContext,
        TodoItemDatabase::class.java, "todo_collection_database"
    ).addMigrations(MIGRATION_1_2).build()
}