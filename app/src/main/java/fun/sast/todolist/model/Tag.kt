package `fun`.sast.todolist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tag(
    @PrimaryKey
    val id: Int,
    val title: String,
    val icon: TagIcon
) {
    enum class TagIcon {
        Home, Work, School, Shopping, Sport, Study, Travel, Other
    }
}
