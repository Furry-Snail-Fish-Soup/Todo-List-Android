package `fun`.sast.todolist.viewmodel

import `fun`.sast.todolist.model.TodoCollection
import `fun`.sast.todolist.repository.TodoCollectionRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodoCollectionViewModel(private val repository: TodoCollectionRepository) : ViewModel() {

    fun insert(todoCollection: TodoCollection) = viewModelScope.launch {
        repository.insert(todoCollection)
    }

    fun update(todoCollection: TodoCollection) = viewModelScope.launch {
        repository.update(todoCollection)
    }

    fun delete(todoCollection: TodoCollection) = viewModelScope.launch {
        repository.delete(todoCollection)
    }

    fun getAllCollections() = viewModelScope.launch {
        repository.getAllCollections()
    }

    fun getAll() = viewModelScope.launch {
        repository.getAll()
    }

    fun getNum(title: String) = viewModelScope.launch {
        repository.getNum(title)
    }
}

class TodoCollectionRepositoryFactory(private val repository: TodoCollectionRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoCollectionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TodoCollectionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}