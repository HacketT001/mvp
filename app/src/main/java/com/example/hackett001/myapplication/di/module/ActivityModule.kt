package com.example.hackett001.myapplication.di.module

import com.example.hackett001.myapplication.di.PerActivity
import com.example.hackett001.myapplication.ui.base.BaseActivity
import com.example.hackett001.myapplication.ui.base.BasePresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(val activity: BaseActivity){

    @Provides
    fun provideContext() = activity

    @Provides
    @PerActivity
    fun provideMainMvpPresenter(presenter: BasePresenter<BaseActivity>) = presenter

}