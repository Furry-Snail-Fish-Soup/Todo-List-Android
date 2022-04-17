package `fun`.sast.todolist.viewmodel

import `fun`.sast.todolist.repository.TodoCollectionRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TodoCollectionViewModel(private val repository: TodoCollectionRepository) : ViewModel() {

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