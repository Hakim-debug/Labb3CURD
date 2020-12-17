package ui

import Repositories.ShoppingRepository
import androidx.lifecycle.ViewModel
import entities.WinesItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository ): ViewModel() {
  //Start a New Coruntinne


  fun upsert(item: WinesItem) = CoroutineScope (Dispatchers.Main).launch {
    repository.upsert(item)
  }
    
  fun delete(item: WinesItem) = CoroutineScope (Dispatchers.Main).launch {
       repository.delete(item)
  }   fun getAllWinesItems() = repository.getAllWineItems()

}
