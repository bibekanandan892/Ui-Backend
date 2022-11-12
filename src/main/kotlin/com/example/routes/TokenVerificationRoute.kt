package com.example.routes

import com.example.domain.model.ApiRequest
import com.example.domain.model.Endpoint
import com.example.domain.model.User
import com.example.domain.model.UserSession
import com.example.domain.repository.UserDataSource
import com.example.utils.Constants.AUDIENCE
import com.example.utils.Constants.ISSUER
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.gson.GsonFactory
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.util.pipeline.*

fun Route.tokenVerificationRoute(
    app: Application,
    userDataSource: UserDataSource
) {
    post(Endpoint.TokenVerification.path) {

        val request = call.receive<ApiRequest>()

        if (request.tokenId.isNotEmpty()) {
            if (request.tokenId == "123") {
                saveUserToDatabase(
                    app = app,
                    result = request,
                    userDataSource = userDataSource
                )
            }
        } else {
            app.log.info("EMPTY TOKEN ID ")
            call.respondRedirect(Endpoint.Unauthorized.path)
        }

    }
}


private suspend fun PipelineContext<Unit, ApplicationCall>.saveUserToDatabase(
    app: Application,
    result: ApiRequest,
    userDataSource: UserDataSource
) {
    val token = result.tokenId
    val name = result.userName
    val emailAddress = result.userEmailId
    val profilePhoto = result.profilePhoto
    val user = User(
        id = token,
        name = name,
        emailAddress = emailAddress,
        profilePhoto = profilePhoto
    )

    val response = userDataSource.saveUserInfo(user = user)
    if (response) {
        app.log.info("USER SUCCESSFULLY SAVED/RETRIEVED")
        call.respondRedirect(Endpoint.Authorized.path)
    } else {
        app.log.info("ERROR SAVING THE USER")
        call.respondRedirect(Endpoint.Unauthorized.path)
    }
}