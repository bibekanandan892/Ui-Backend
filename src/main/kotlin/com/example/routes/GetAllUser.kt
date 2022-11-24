package com.example.routes

import com.example.domain.model.ApiResponse
import com.example.domain.model.Endpoint
import com.example.domain.model.isuApp.AllUserListResponse
import com.example.domain.model.isuApp.userId.UserId
import com.example.domain.repository.UiDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllUser(
    app: Application,
    uiDataSource: UiDataSource
) {
    get(Endpoint.GetAllUser.path) {
        try {
            call.respond(
                message = AllUserListResponse(
                    allUser = uiDataSource.getAllUser()
                ),
                status = HttpStatusCode.OK
            )
        } catch (e: Exception) {
            app.log.info("GETTING USER INFO ERROR: ${e.message}")
            call.respondRedirect(Endpoint.Unauthorized.path)
        }
    }


}