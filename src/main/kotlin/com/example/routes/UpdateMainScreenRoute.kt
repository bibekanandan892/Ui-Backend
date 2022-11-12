package com.example.routes

import com.example.domain.model.ApiResponse
import com.example.domain.model.Endpoint
import com.example.domain.model.ui.MainScreen
import com.example.domain.repository.UiDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*

fun Route.updateMainScreenRoute(
    app: Application,
    uiDataSource: UiDataSource
) {
        put(Endpoint.UpdateMainScreen.path) {
            val mainScreenUpdate = call.receive<MainScreen>()
            app.log.info("UPDATE MAIN SCREEN INFO ERROR: $23456")

            try {
                    updateMainScreen(
                        app = app,
                        uiId = "123",
                        updateMainScreen = mainScreenUpdate,
                        uiDataSource = uiDataSource
                    )
                } catch (e: Exception) {
                    app.log.info("UPDATE MAIN SCREEN INFO ERROR: $e")
                    call.respondRedirect(Endpoint.Unauthorized.path)
                }
            }

}

private suspend fun PipelineContext<Unit, ApplicationCall>.updateMainScreen(
    app: Application,
    uiId: String,
    updateMainScreen: MainScreen,
    uiDataSource: UiDataSource
) {
    val response = uiDataSource.updateMainScreenUI(
        uiId = uiId,
        mainScreenUi = updateMainScreen
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