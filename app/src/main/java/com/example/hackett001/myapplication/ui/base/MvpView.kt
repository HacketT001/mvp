package com.example.hackett001.myapplication.ui.base

interface MvpView {

    fun showLoding()

    fun hideLoading()

    fun onError(message: String)

    fun disableInteraction()

    fun enableInteraction()

}