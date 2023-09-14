package com.shoppi_app.repository

import com.shoppi_app.model.Category
import com.shoppi_app.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient) : CategoryDataSource {
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}