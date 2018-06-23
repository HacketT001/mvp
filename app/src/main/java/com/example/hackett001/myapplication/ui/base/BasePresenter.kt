package com.example.hackett001.myapplication.ui.base

open class BasePresenter<T : MvpView> : MvpPresenter<T> {

    private var view: T? = null

    override fun onAttach(view: T) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }

    fun isViewAttached(): Boolean {
        return view != null
    }

    fun getView(): T? {
        return view
    }

    override fun handleApiError() {

    }

}