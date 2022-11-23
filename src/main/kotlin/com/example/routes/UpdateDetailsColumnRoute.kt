package com.example.routes

import com.example.domain.model.Endpoint
import com.example.domain.model.ui.DetailsColumn
import com.example.domain.repository.UiDataSource
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

fun Route.updateDetailsColumnRoute(
    app: Application,
    uiDataSource: UiDataSource
) {
    put(Endpoint.UpdateDetailsColumn.path) {
        val updateDetailsColumnUI = call.receive<DetailsColumn>()
        app.log.info("UPDATE Row Item UI INFO ERROR: $23456")

        try {
            updateDetailsColumnUI(
                app = app,
                uiId = "123",
                updateDetailsColumnUI = updateDetailsColumnUI,
                uiDataSource = uiDataSource
            )
        } catch (e: Exception) {
            app.log.info("UPDATE Row Item UI INFO ERROR: $e")
            call.respondRedirect(Endpoint.Unauthorized.path)
        }
    }
}

private suspend fun PipelineContext<Unit, ApplicationCall>.updateDetailsColumnUI(
    app: Application,
    uiId: String,
    uiDataSource: UiDataSource,
    updateDetailsColumnUI: DetailsColumn
) {
//    val response = uiDataSource.updateDetailsColumn(
//        uiId = uiId,
//        detailsColumnUi = updateDetailsColumnUI
//    )
//    if (response) {
//        app.log.info("Row Item UI SUCCESSFULLY UPDATED")
//        call.respond(
//            message = ApiResponse(
//                success = true,
//                message = "Successfully Updated!"
//            ),
//            status = HttpStatusCode.OK
//        )
//    } else {
//        app.log.info("ERROR UPDATING THE Row Item UI")
//        call.respond(
//            message = ApiResponse(success = false),
//            status = HttpStatusCode.BadRequest
//        )
//    }
}