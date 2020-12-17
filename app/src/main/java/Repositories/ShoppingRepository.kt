package Repositories

import db.WineListDataBase
import entities.WinesItem

class ShoppingRepository (private val db: WineListDataBase){

    suspend fun upsert(item: WinesItem) = db.getWineShoppingDao().upsert(item)

    suspend fun delete(item: WinesItem) = db.getWineShoppingDao().delete(item)

    fun getAllWineItems() = db.getWineShoppingDao().getAllShoppingItems()
}