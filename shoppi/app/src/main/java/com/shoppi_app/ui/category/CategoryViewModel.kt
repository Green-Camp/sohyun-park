package com.shoppi_app.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shoppi_app.model.Category
import com.shoppi_app.repository.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val categoryRepository : CategoryRepository
) : ViewModel(){

    private val _items = MutableLiveData<List<Category>>()
    val items : LiveData<List<Category>> = _items

    init {
        loadCategory()
    }

    private fun loadCategory(){
        viewModelScope.launch {
            val categories = categoryRepository.getCategories()
            _items.value = categories
        }
    }
}