package com.example.routes

import com.example.domain.model.ApiResponse
import com.example.domain.model.Endpoint
import com.example.domain.repository.UiDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getUiRoute(
    app: Application,
    uiDataSource: UiDataSource
) {
    get(Endpoint.GetUiScreen.path) {
        try {
            call.respond(
                message = ApiResponse(
                    success = true,
                    ui = uiDataSource.getUIInfo(uiId = "123")
                ),
                status = HttpStatusCode.OK
            )
        } catch (e: Exception) {
            app.log.info("GETTING USER INFO ERROR: ${e.message}")
            call.respondRedirect(Endpoint.Unauthorized.path)
        }
    }


}