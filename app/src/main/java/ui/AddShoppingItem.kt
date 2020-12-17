package ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.wineshoppinglist.R
import entities.WinesItem
import kotlinx.android.synthetic.main.add_shopping_item.*

class AddShoppingItem(context: Context,var add: Add) : AppCompatDialog(context) {


override fun onCreate(saveInstanceState: Bundle?){
    super.onCreate(saveInstanceState)
    setContentView(R.layout.add_shopping_item)

    tvAdd.setOnClickListener {
        val name = etName.text.toString()
        val amount = etAmount.text.toString()

        if (name.isEmpty() || amount.isEmpty()){
            Toast.makeText(context, "Please enter all information", Toast.LENGTH_LONG).show()
            return@setOnClickListener
        }

        var item = WinesItem(name, amount.toInt())
        add.onAddButtonClicked(item)
        dismiss()

    }

    tvCancel.setOnClickListener {
        cancel()

    }
}

}

//private fun AddShoppingItem.onAddButtonClicked(item: WinesItem) {


//}
