package `fun`.sast.nothingtodo.dao

import `fun`.sast.nothingtodo.model.CollectionWithItems
import `fun`.sast.nothingtodo.model.TodoCollection
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoCollectionDao {
    /**
     * Get all TodoCollection's.
     * The list is sorted by the collection's id in descending order.
     * @return all TodoCollection's.
     */
    @Query("SELECT * FROM TodoCollection ORDER BY id DESC")
    suspend fun getAllCollections(): Flow<List<TodoCollection>>

    /**
     * Get all TodoCollection's with their corresponding items.
     * The list is sorted by the collection's id in descending order.
     * @return all TodoCollection's.
     */
    @Transaction
    @Query("SELECT * FROM TodoCollection ORDER BY id DESC")
    suspend fun getAll(): Flow<List<CollectionWithItems>>

    @Transaction
    @Query("SELECT Count(*) FROM TodoCollection where title = :title")
    suspend fun getNum(title: String): Int

    /**
     * Insert a TodoCollection into the database. If the collection already exists, abort.
     * @param collection the collection to be inserted.
     * @return the rowId of the collection.
     */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(todoCollection: TodoCollection): Long

    /**
     * Delete a TodoCollection from the database.
     * @param collection the collection to be deleted.
     * @return the number of rows affected.
     */
    @Delete
    suspend fun delete(collection: TodoCollection): Int

    /**
     * Update a TodoCollection in the database.
     * @param collection the collection to be updated.
     * @return the number of rows affected.
     */
    @Update
    suspend fun update(collection: TodoCollection): Int
}
