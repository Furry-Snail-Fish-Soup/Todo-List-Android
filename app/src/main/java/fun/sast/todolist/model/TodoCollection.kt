package `fun`.sast.todolist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoCollection(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val icon: Icon
) {
    enum class Icon {
        Work, Study, Home, Other
    }
}
