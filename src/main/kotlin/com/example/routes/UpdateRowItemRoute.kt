package com.example.routes

import com.example.domain.model.ApiResponse
import com.example.domain.model.Endpoint
import com.example.domain.model.ui.RowItem
import com.example.domain.repository.UiDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

fun Route.updateRowItemRoute(
    app: Application,
    uiDataSource: UiDataSource
) {
    put(Endpoint.UpdateRowItem.path) {
        val updateRowItemUI = call.receive<RowItem>()
        app.log.info("UPDATE Row Item UI INFO ERROR: $23456")

        try {
            updateRowItemUI(
                app = app,
                uiId = "123",
                updateRowItemUI = updateRowItemUI,
                uiDataSource = uiDataSource
            )
        } catch (e: Exception) {
            app.log.info("UPDATE Row Item UI INFO ERROR: $e")
            call.respondRedirect(Endpoint.Unauthorized.path)
        }
    }
}

private suspend fun PipelineContext<Unit, ApplicationCall>.updateRowItemUI(
    app: Application,
    uiId: String,
    uiDataSource: UiDataSource,
    updateRowItemUI: RowItem
) {
    val response = uiDataSource.updateRowItemUI(
        uiId = uiId,
        rowItemUi = updateRowItemUI
    )
    if (response) {
        app.log.info("Row Item UI SUCCESSFULLY UPDATED")
        call.respond(
            message = ApiResponse(
                success = true,
                message = "Successfully Updated!"
            ),
            status = HttpStatusCode.OK
        )
    } else {
        app.log.info("ERROR UPDATING THE Row Item UI")
        call.respond(
            message = ApiResponse(success = false),
            status = HttpStatusCode.BadRequest
        )
    }
}