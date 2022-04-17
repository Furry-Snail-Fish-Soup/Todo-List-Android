package `fun`.sast.todolist.repository

import `fun`.sast.todolist.dao.TodoCollectionDao
import `fun`.sast.todolist.model.CollectionWithItems
import `fun`.sast.todolist.model.TodoCollection
import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class TodoCollectionRepository(private val todoCollectionDao: TodoCollectionDao) {

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(todoCollection: TodoCollection): Long {
        return todoCollectionDao.insert(todoCollection)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(todoCollection: TodoCollection): Int {
        return todoCollectionDao.delete(todoCollection)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(todoCollection: TodoCollection): Int {
        return todoCollectionDao.update(todoCollection)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getAllCollections(): Flow<List<TodoCollection>> {
        return todoCollectionDao.getAllCollections()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getAll(): Flow<List<CollectionWithItems>> {
        return todoCollectionDao.getAll();
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getNum(title: String): Int {
        return todoCollectionDao.getNum(title);
    }
}