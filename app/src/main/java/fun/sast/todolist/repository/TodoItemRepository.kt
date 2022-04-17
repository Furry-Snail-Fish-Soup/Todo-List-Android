package `fun`.sast.todolist.repository

import `fun`.sast.todolist.dao.TodoItemDao
import `fun`.sast.todolist.model.TodoItem
import androidx.annotation.WorkerThread

class TodoItemRepository(private val TodoItemDao: TodoItemDao) {

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(todoItem: TodoItem) {
        TodoItemDao.insert(todoItem)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(todoItem: TodoItem) {
        TodoItemDao.delete(todoItem)
    }

}