package com.example.hackett001.myapplication.di.component

import android.app.Application
import com.example.hackett001.myapplication.App
import com.example.hackett001.myapplication.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent{

    fun inject(application: App)
}