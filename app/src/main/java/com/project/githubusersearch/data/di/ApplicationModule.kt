package com.project.githubusersearch.data.di

import android.app.Application
import android.content.Context
import com.project.githubusersearch.data.local.GithubUserDatabase
import com.project.githubusersearch.data.remote.api.ApiCallback
import com.project.githubusersearch.data.remote.repository.MainRepository
import com.project.githubusersearch.data.remote.source.data.MainDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DatabaseModule::class])
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    fun provideApplication(application: Application): Context = application

    @Provides
    fun provideMainRepository(
        apiCallback: ApiCallback,
        githubUserDB: GithubUserDatabase
    ) = MainRepository(
        MainDataSource(apiCallback, githubUserDB)
    )
}