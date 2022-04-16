package `fun`.sast.todolist

import androidx.lifecycle.ViewModel
import kotlinx.datetime.LocalDateTime

class TodoItemViewModel(var isCompleted: Boolean, var content: String) : ViewModel() {
}
