package com.example.hackett001.myapplication.di.module

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.example.hackett001.myapplication.di.PerActivity
import com.example.hackett001.myapplication.ui.base.BaseActivity
import com.example.hackett001.myapplication.ui.base.BasePresenter
import com.example.hackett001.myapplication.ui.main.MainMvpPresenter
import com.example.hackett001.myapplication.ui.main.MainMvpView
import com.example.hackett001.myapplication.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule(val activity: AppCompatActivity) {

    @Provides
    fun provideContext(): Context = activity

/*

    @Provides
    @PerActivity
    fun provideMainMvpPresenter(presenter: MainPresenter<MainMvpView>): MainMvpPresenter<MainMvpView> = presenter
*/

    @Provides
    @PerActivity
    fun provide(): MainMvpPresenter<MainMvpView> = MainPresenter()

}