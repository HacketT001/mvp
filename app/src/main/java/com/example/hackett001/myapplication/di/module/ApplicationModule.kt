package com.example.hackett001.myapplication.di.module

import android.app.Application
import dagger.Module
import dagger.Provides


@Module
class ApplicationModule(val application: Application){
    @Provides
    fun provideAppContext() = application

    @Provides
    fun provideApplication() = application
}