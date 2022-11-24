package com.example.domain.repository

import com.example.domain.model.GridUpdateRequest
import com.example.domain.model.isuApp.UI
import com.example.domain.model.ui.*

interface UiDataSource {
    suspend fun getUIInfo(uiId : String) : UI?
    suspend fun saveUIInfo(ui : UI) : Boolean

    suspend fun updateGridItem(uiId : String, gridUpdateRequest: GridUpdateRequest) : Boolean


    suspend fun getAllUser():  List<String>

    suspend fun deleteUI(uiId : String) : Boolean
    suspend fun updateImageUI(
        uiId: String ,
        ImageUi : Image,
    ): Boolean
    suspend fun updateDetailsColumn(
        uiId: String ,
        detailsColumnUi: DetailsColumn,
    ): Boolean
    suspend fun updateRowItemUI(
        uiId: String ,
        rowItemUi: RowItem,
    ): Boolean
    suspend fun updateMainScreenUI(
        uiId: String ,
        mainScreenUi: MainScreen,
    ): Boolean
}