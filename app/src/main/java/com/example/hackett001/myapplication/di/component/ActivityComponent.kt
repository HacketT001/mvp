package com.example.hackett001.myapplication.di.component

import com.example.hackett001.myapplication.di.PerActivity
import com.example.hackett001.myapplication.di.module.ActivityModule
import com.example.hackett001.myapplication.ui.base.BaseActivity
import com.example.hackett001.myapplication.ui.main.MainActivity
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {


    fun inject(activity: MainActivity)

    //fun inject(activity: BaseActivity)
}