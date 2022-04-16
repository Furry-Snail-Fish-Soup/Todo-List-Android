package `fun`.sast.todolist.model

data class TodoList(val id: Int, val title: String, val color: Color) {
    enum class Color {
        Red, Green, Blue, Yellow, Purple, Orange
    }
}
