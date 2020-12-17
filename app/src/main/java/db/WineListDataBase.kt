package db

import entities.WinesItem
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =
    [WinesItem::class],
    version = 1)


abstract class WineListDataBase: RoomDatabase() {
    abstract  fun getWineShoppingDao(): WineShoppingDoa

    companion object {

        @Volatile
        private var instance: WineListDataBase? = null
        private val LOCK = Any()

        operator fun invoke (context: Context) = instance ?: synchronized(LOCK){
            instance ?: creatDatabase(context).also { instance = it }
        }

        private fun creatDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, WineListDataBase::class.java, "ShoppingDB.db").build()

    }


}