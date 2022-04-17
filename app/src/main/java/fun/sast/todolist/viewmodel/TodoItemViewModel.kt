package `fun`.sast.todolist.viewmodel

import `fun`.sast.todolist.model.TodoItem
import `fun`.sast.todolist.repository.TodoItemRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodoItemViewModel(private val repository: TodoItemRepository) : ViewModel() {

    fun insert(todoItem: TodoItem) = viewModelScope.launch {
        repository.insert(todoItem)
    }

    fun update(todoItem: TodoItem) = viewModelScope.launch {
        repository.update(todoItem)
    }

    fun delete(todoItem: TodoItem) = viewModelScope.launch {
        repository.delete(todoItem)
    }

    fun getAll() = viewModelScope.launch {
        repository.getAll()
    }

}

class TodoItemViewModelFactory(private val repository: TodoItemRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TodoItemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}