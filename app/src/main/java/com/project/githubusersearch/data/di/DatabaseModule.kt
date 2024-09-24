package com.project.githubusersearch.data.di

import android.content.Context
import androidx.room.Room
import com.project.githubusersearch.data.local.GithubUserDatabase
import com.project.githubusersearch.util.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

     @Singleton
     @Provides
     fun provideDatabase(
        @ApplicationContext context: Context
     ) = Room.databaseBuilder(
        context,
        GithubUserDatabase::class.java,
        Const.DATABASE
     ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideSearchHistoryDao(database: GithubUserDatabase) = database.userListDao()

}