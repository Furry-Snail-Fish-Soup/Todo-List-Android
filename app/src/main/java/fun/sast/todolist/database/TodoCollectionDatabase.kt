package `fun`.sast.todolist.database

import `fun`.sast.todolist.dao.TodoCollectionDao
import `fun`.sast.todolist.model.TodoCollection
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodoCollection::class], version = 1)
abstract class TodoCollectionDatabase : RoomDatabase() {

    abstract fun TodoCollectionDao(): TodoCollectionDao

    companion object {
        @Volatile
        private var INSTANCE: TodoCollectionDatabase? = null

        fun getDatabase(context: Context): TodoCollectionDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoCollectionDatabase::class.java,
                    "todo_collection_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}