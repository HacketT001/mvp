package com.example.hackett001.myapplication.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.hackett001.myapplication.R
import com.example.hackett001.myapplication.ui.base.BaseActivity
import com.example.hackett001.myapplication.ui.base.MvpView
import javax.inject.Inject

class MainActivity: BaseActivity(), MainMvpView {

    @Inject
    lateinit var presenter: MainMvpPresenter<MainMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getActivityComponent().inject(this)

        presenter.onAttach(this)

        Log.d("PRESENTER", presenter.toString())
    }



}