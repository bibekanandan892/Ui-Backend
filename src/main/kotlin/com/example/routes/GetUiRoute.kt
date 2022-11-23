package com.example.routes

import com.example.domain.model.ApiResponse
import com.example.domain.model.Endpoint
import com.example.domain.model.isuApp.userId.UserId
import com.example.domain.model.ui.UiRequest
import com.example.domain.repository.UiDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getUiRoute(
    app: Application,
    uiDataSource: UiDataSource
) {
    post(Endpoint.GetUiScreen.path) {
        val request = call.receive<UserId>()
        try {
            call.respond(
                message = ApiResponse(
                    success = true,
                    ui = uiDataSource.getUIInfo(uiId = request.userId)
                ),
                status = HttpStatusCode.OK
            )
        } catch (e: Exception) {
            app.log.info("GETTING USER INFO ERROR: ${e.message}")
            call.respondRedirect(Endpoint.Unauthorized.path)
        }
    }


}