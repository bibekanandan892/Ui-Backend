package com.example.routes

import com.example.domain.model.ApiResponse
import com.example.domain.model.Endpoint
import com.example.domain.repository.UiDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

fun Route.deleteUserRoute(
    app: Application,
    uiDataSource: UiDataSource
) {
    delete(Endpoint.DeleteUser.path) {
        try {
            deleteUserFromDb(
                app = app,
                uiId = "123",
                uiDataSource = uiDataSource
            )
        } catch (e: Exception) {
            app.log.info("DELETING USER ERROR: ${e.message}")
            call.respondRedirect(Endpoint.Unauthorized.path)
        }
    }
}


private suspend fun PipelineContext<Unit, ApplicationCall>.deleteUserFromDb(
    app: Application,
    uiId: String,
    uiDataSource: UiDataSource
) {
    val result = uiDataSource.deleteUI(uiId = uiId)
    if (result) {
        app.log.info("USER SUCCESSFULLY DELETED")
        call.respond(
            message = ApiResponse(success = true),
            status = HttpStatusCode.OK
        )
    } else {
        app.log.info("ERROR DELETING THE USER")
        call.respond(
            message = ApiResponse(success = false),
            status = HttpStatusCode.BadRequest
        )
    }
}