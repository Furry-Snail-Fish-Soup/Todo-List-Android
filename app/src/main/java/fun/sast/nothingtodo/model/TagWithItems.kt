package `fun`.sast.nothingtodo.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class TagWithItems(
    @Embedded val tag: Tag,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(ItemTag::class, parentColumn = "tagId", entityColumn = "itemId")
    ) val Items: List<Tag>
)
