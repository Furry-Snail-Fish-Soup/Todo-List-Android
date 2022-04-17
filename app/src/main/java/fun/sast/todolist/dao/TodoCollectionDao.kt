package `fun`.sast.todolist.dao

import `fun`.sast.todolist.model.CollectionWithItems
import `fun`.sast.todolist.model.TodoCollection
import androidx.room.*

@Dao
interface TodoCollectionDao {
    /**
     * Get all TodoCollection's.
     * The list is sorted by the collection's id in descending order.
     * @return all TodoCollection's.
     */
    @Query("SELECT * FROM TodoCollection ORDER BY id DESC")
    suspend fun getAllCollections(): List<TodoCollection>

    /**
     * Get all TodoCollection's with their corresponding items.
     * The list is sorted by the collection's id in descending order.
     * @return all TodoCollection's.
     */
    @Query("SELECT * FROM TodoCollection ORDER BY id DESC")
    suspend fun getAllCollectionsWithItems(): List<CollectionWithItems>

    /**
     * Insert a TodoCollection into the database. If the collection already exists, abort.
     * @param collection the collection to be inserted.
     * @return the rowId of the collection.
     */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertCollection(todoCollection: TodoCollection): Long

    /**
     * Delete a TodoCollection from the database.
     * @param collection the collection to be deleted.
     * @return the number of rows affected.
     */
    @Delete
    suspend fun deleteCollection(collection: TodoCollection): Long

    /**
     * Update a TodoCollection in the database.
     * @param collection the collection to be updated.
     * @return the number of rows affected.
     */
    @Update
    suspend fun updateCollection(collection: TodoCollection): Long
}
