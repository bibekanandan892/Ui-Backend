package com.example.data

import com.example.domain.model.GridUpdateRequest
import com.example.domain.model.isuApp.*
import com.example.domain.model.ui.*
import com.example.domain.repository.UiDataSource
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.div
import org.litote.kmongo.eq
import org.litote.kmongo.setValue

class UiDataSourceImpl(database: CoroutineDatabase) : UiDataSource {
    private val ui = database.getCollection<UI>()
    override suspend fun getUIInfo(uiId: String): UI? {
        return ui.findOne(filter = UI::id eq uiId)
    }
    override suspend fun saveUIInfo(ui: UI): Boolean {
        val existingUser = this.ui.findOne(filter = UI::id eq ui.id)

        return if (existingUser == null) {
            this.ui.insertOne(document = ui).wasAcknowledged()
        } else {
            true
        }
    }

    override suspend fun updateGridItem(uiId: String, gridUpdateRequest: GridUpdateRequest): Boolean {

        return ui.updateOne(filter = UI::id eq uiId, update = setValue(
            property = UI::gridLayout/GridLayout::gridItem/GridItem::items,
            value = gridUpdateRequest.items
        )).wasAcknowledged()
    }

    override suspend fun deleteUI(uiId: String): Boolean {
        return ui.deleteOne(filter = UI::id eq uiId).wasAcknowledged()
    }

    override suspend fun updateImageUI(
        uiId: String,
        ImageUi: Image
    ): Boolean {
//        return ui.updateOne(
//            filter = UI::id eq uiId,
//            update = setValue(
//                property = UI::image,
//                value = ImageUi
//            )
//        ).wasAcknowledged()
        return  true
    }
    override suspend fun updateDetailsColumn(uiId: String, detailsColumnUi: DetailsColumn): Boolean {
//        return ui.updateOne(
//            filter = UI::id eq uiId,
//            update = setValue(
//                property = UI::detailsColumn,
//                value = detailsColumnUi
//            )
//        ).wasAcknowledged()
        return  true

    }
    override suspend fun updateRowItemUI(uiId: String, rowItemUi: RowItem): Boolean {
//        return ui.updateOne(
//            filter = UI::id eq uiId,
//            update = setValue(
//                property = UI::rowItem,
//                value = rowItemUi
//            )
//        ).wasAcknowledged()
        return  true

    }
    override suspend fun updateMainScreenUI(uiId: String, mainScreenUi: MainScreen): Boolean {
//        return ui.updateOne(
//            filter = UI::id eq uiId,
//            update = setValue(
//                property = UI::,
//                value = mainScreenUi
//            )
//        ).wasAcknowledged()
        return  true

    }
}