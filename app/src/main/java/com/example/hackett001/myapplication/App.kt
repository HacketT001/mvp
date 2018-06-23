package com.example.hackett001.myapplication

import android.app.Application
import com.example.hackett001.myapplication.di.component.ApplicationComponent
import com.example.hackett001.myapplication.di.component.DaggerApplicationComponent
import com.example.hackett001.myapplication.di.module.ApplicationModule
import kotlinx.android.synthetic.main.activity_main.view.*

class App : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initDaggerComponent()
    }

    fun getComponent(): ApplicationComponent = applicationComponent

    private fun initDaggerComponent() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()

        applicationComponent.inject(this)
    }
}