package com.shoppi_app.repository

import com.shoppi_app.model.Category

interface CategoryDataSource {
    suspend fun getCategories(): List<Category>
}