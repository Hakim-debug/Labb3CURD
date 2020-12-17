package entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.temporal.TemporalAmount

@Entity(tableName = "wines_items")

data class WinesItem (@ColumnInfo(name = "item_name" ) var name: String,
                      @ColumnInfo(name = "item_amount" )var amount: Int)
 {
     //The key for the data base and id genarete all id
     @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}

//Telling the room object what to do whit the data