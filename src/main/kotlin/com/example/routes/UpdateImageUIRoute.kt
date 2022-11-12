package com.example.routes

import com.example.domain.model.ApiResponse
import com.example.domain.model.Endpoint
import com.example.domain.model.ui.Image
import com.example.domain.model.ui.MainScreen
import com.example.domain.repository.UiDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

fun Route.updateImageUiRoute(
    app: Application,
    uiDataSource: UiDataSource
) {
    put(Endpoint.UpdateImageUI.path) {
        val imageUpdate = call.receive<Image>()
        app.log.info("UPDATE MAIN SCREEN INFO ERROR: $23456")

        try {
            updateImageUI(
                app = app,
                uiId = "123",
                updateImageUI = imageUpdate,
                uiDataSource = uiDataSource
            )
        } catch (e: Exception) {
            app.log.info("UPDATE MAIN SCREEN INFO ERROR: $e")
            call.respondRedirect(Endpoint.Unauthorized.path)
        }
    }

}

private suspend fun PipelineContext<Unit, ApplicationCall>.updateImageUI(
    app: Application,
    uiId: String,
    uiDataSource: UiDataSource,
    updateImageUI: Image
) {
    val response = uiDataSource.updateImageUI(
        uiId = uiId,
        ImageUi = updateImageUI
    )
    if (response) {
        app.log.info("MAIN SCREEN SUCCESSFULLY UPDATED")
        call.respond(
            message = ApiResponse(
                success = true,
                message = "Successfully Updated!"
            ),
            status = HttpStatusCode.OK
        )
    } else {
        app.log.info("ERROR UPDATING THE MAIN SCREEN")
        call.respond(
            message = ApiResponse(success = false),
            status = HttpStatusCode.BadRequest
        )
    }
}