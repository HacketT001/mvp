package com.example.hackett001.myapplication.ui.base

interface MvpPresenter <T : MvpView> {

    fun onAttach(view: T)

    fun onDetach()

    fun handleApiError()

}