package `fun`.sast.todolist.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ItemWithTags(
    @Embedded val item: TodoItem,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(ItemTag::class, parentColumn = "itemId", entityColumn = "tagId")
    ) val tags: List<Tag>
)
