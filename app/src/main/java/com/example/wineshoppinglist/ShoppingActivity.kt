package com.example.wineshoppinglist

import Repositories.ShoppingRepository
import db.WineListDataBase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wineshoppinglist.other.ShoppingItemAdapter
import entities.WinesItem
import kotlinx.android.synthetic.main.activity_shopping.*
import ui.Add
import ui.AddShoppingItem
import ui.ShoppingViewModel
import ui.ShoppingViewModelFactory
import java.util.EnumSet.of

class ShoppingActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        //
        val database = WineListDataBase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)
        val adapter = ShoppingItemAdapter(listOf(),viewModel)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.getAllWinesItems().observe(this, Observer {
         adapter.items = it
            adapter.notifyDataSetChanged()

        })
        fab.setOnClickListener {
            AddShoppingItem(this, object: Add{
                override fun onAddButtonClicked(item: WinesItem) {

                    viewModel.upsert(item)
                }

            }).show()
        }
    }


}
