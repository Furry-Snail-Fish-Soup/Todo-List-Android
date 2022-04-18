package `fun`.sast.nothingtodo.model

import androidx.room.Embedded
import androidx.room.Relation

data class CollectionWithItems(
    @Embedded val todoCollection: TodoCollection,
    @Relation(parentColumn = "id", entityColumn = "collectionId")
    val items: List<TodoItem>
)
