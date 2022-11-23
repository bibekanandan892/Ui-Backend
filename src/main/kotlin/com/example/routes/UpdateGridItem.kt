package com.example.routes

import com.example.domain.model.ApiResponse
import com.example.domain.model.Endpoint
import com.example.domain.model.GridUpdateRequest
import com.example.domain.model.isuApp.Item
import com.example.domain.model.ui.DetailsColumn
import com.example.domain.repository.UiDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

fun Route.updateGridItem(
    app: Application,
    uiDataSource: UiDataSource
) {
    put(Endpoint.UpdateGridItem.path) {
        val updateGridRequest = call.receive<GridUpdateRequest>()
        app.log.info("UPDATE Row Item UI INFO ERROR: $23456")

        try {
            updateGridItem(
                app = app,
                uiId = updateGridRequest.uiId,
                updateGridItemRequest = updateGridRequest,
                uiDataSource = uiDataSource
            )
        } catch (e: Exception) {
            app.log.info("UPDATE Row Item UI INFO ERROR: $e")
            call.respondRedirect(Endpoint.Unauthorized.path)
        }
    }
}

private suspend fun PipelineContext<Unit, ApplicationCall>.updateGridItem(
    app: Application,
    uiId: String,
    uiDataSource: UiDataSource,
    updateGridItemRequest: GridUpdateRequest
) {
    val response = uiDataSource.updateGridItem(
        uiId = uiId,
        gridUpdateRequest = updateGridItemRequest
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