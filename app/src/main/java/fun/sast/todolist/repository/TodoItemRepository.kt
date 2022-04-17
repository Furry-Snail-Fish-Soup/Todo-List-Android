package `fun`.sast.todolist.repository

import `fun`.sast.todolist.dao.TodoItemDao
import `fun`.sast.todolist.model.TodoItem
import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class TodoItemRepository(private val TodoItemDao: TodoItemDao) {
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(todoItem: TodoItem): Long {
        return TodoItemDao.insert(todoItem)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(todoItem: TodoItem) {
        TodoItemDao.delete(todoItem)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(todoItem: TodoItem) {
        TodoItemDao.update(todoItem)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getAll(): Flow<List<TodoItem>> {
        return TodoItemDao.getAll()
    }
}