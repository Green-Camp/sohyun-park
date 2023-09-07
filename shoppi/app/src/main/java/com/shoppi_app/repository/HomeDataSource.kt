package com.shoppi_app.repository

import com.shoppi_app.model.HomeData

interface HomeDataSource {
    fun getHomeData() : HomeData?
}