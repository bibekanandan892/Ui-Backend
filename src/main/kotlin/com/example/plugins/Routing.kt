package com.example.plugins

import com.example.domain.repository.UiDataSource
import com.example.routes.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import org.koin.java.KoinJavaComponent

fun Application.configureRouting() {
    routing {
        val uiDataSource: UiDataSource by KoinJavaComponent.inject(UiDataSource::class.java)
        rootRoute()
        saveUiRoute(application,uiDataSource)
        getUiRoute(application,uiDataSource)
        updateGridItem(application,uiDataSource)
        updateMainScreenRoute(application,uiDataSource)
        updateDetailsColumnRoute(application,uiDataSource)
        updateImageUiRoute(application,uiDataSource)
        updateRowItemRoute(application,uiDataSource)
        deleteUserRoute(application,uiDataSource)
        authorizedRoute()
        unauthorizedRoute()
    }
}
