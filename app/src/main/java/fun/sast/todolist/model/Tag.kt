package `fun`.sast.todolist.model

data class Tag(val id: Int, val title: String, val icon: Icon) {
    enum class Icon {
        Home, Work, School, Shopping, Sport, Study, Travel, Other
    }
}
