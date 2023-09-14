package com.shoppi_app.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shoppi_app.AssetLoader
import com.shoppi_app.network.ApiClient
import com.shoppi_app.repository.CategoryRemoteDataSource
import com.shoppi_app.repository.CategoryRepository
import com.shoppi_app.repository.HomeAssetDataSource
import com.shoppi_app.repository.HomeRepository
import com.shoppi_app.ui.category.CategoryViewModel
import com.shoppi_app.ui.home.HomeViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                HomeViewModel(repository) as T
            }

            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                val repository = CategoryRepository(CategoryRemoteDataSource(ApiClient.create()))
                CategoryViewModel(repository) as T
            }

            else -> {
                throw IllegalArgumentException("Failed to create ViewModel : ${modelClass.name}")
            }
        }
    }
}