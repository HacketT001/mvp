package com.example.hackett001.myapplication.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.hackett001.myapplication.R
import com.example.hackett001.myapplication.ui.base.BaseActivity
import com.example.hackett001.myapplication.ui.base.MvpView

class MainActivity: BaseActivity(), MainMvpView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }



}