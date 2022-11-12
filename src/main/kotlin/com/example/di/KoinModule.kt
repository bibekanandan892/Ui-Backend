package com.example.di

import com.example.data.UiDataSourceImpl
import com.example.domain.repository.UiDataSource
import com.example.utils.Constants.DATABASE_NAME
import com.mongodb.ConnectionString
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo


val koinModule = module {

    single {
        KMongo.createClient(ConnectionString("mongodb+srv://Bibek:4uzmr8HarQfklzcP@cluster0.2geeidr.mongodb.net/?retryWrites=true&w=majority"))
            .coroutine
            .getDatabase(DATABASE_NAME)
    }
    single<UiDataSource> {
        UiDataSourceImpl(get())
    }

}