package db

import entities.WinesItem
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WineShoppingDoa {
//Replace Items from the data base

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: WinesItem)


    @Delete
   suspend fun delete(item: WinesItem)
@Query(value = "SELECT * FROM wines_items")
   fun getAllShoppingItems(): LiveData<List<WinesItem>>
}