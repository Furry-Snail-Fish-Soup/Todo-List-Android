package `fun`.sast.todolist.repository

import `fun`.sast.todolist.dao.TodoCollectionDao
import `fun`.sast.todolist.model.TodoCollection
import androidx.annotation.WorkerThread

class TodoCollectionRepository(private val todoCollectionDao: TodoCollectionDao) {

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(todoCollection: TodoCollection): Long {
        return todoCollectionDao.insertCollection(todoCollection)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(todoCollection: TodoCollection): Long {
        return todoCollectionDao.deleteCollection(todoCollection)
    }
}