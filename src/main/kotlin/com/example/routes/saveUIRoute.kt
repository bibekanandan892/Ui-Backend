package com.example.routes

import com.example.domain.model.Endpoint
import com.example.domain.model.isuApp.UI
import com.example.domain.model.ui.UiRequest
import com.example.domain.repository.UiDataSource
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

fun Route.saveUiRoute(
    app: Application,
    uiDataSource: UiDataSource
) {
    post(Endpoint.SaveUi.path) {
        val request = call.receive<UiRequest>()
        if (request.UI.id.isNotEmpty()) {
            if ( uiDataSource.getUIInfo(request.UI.id) == null) {
                saveUserToDatabase(
                    app = app,
                    mainUI = request.UI,
                    uiDataSource = uiDataSource
                )
            }
        } else {
            call.respondRedirect(Endpoint.Unauthorized.path)
        }
    }
}


private suspend fun PipelineContext<Unit, ApplicationCall>.saveUserToDatabase(
    app: Application,
    mainUI : UI,
    uiDataSource: UiDataSource
) {


    val response = uiDataSource.saveUIInfo(ui = mainUI)
    if (response) {
        app.log.info("USER SUCCESSFULLY SAVED/RETRIEVED")
        call.respondRedirect(Endpoint.Authorized.path)
    } else {
        app.log.info("ERROR SAVING THE USER")
        call.respondRedirect(Endpoint.Unauthorized.path)
    }
}