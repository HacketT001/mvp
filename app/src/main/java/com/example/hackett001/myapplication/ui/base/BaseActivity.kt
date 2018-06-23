package com.example.hackett001.myapplication.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.RelativeLayout
import android.widget.ProgressBar
import android.widget.Toast
import com.example.hackett001.myapplication.App
import com.example.hackett001.myapplication.di.component.ActivityComponent
import com.example.hackett001.myapplication.di.component.DaggerActivityComponent
import com.example.hackett001.myapplication.di.module.ActivityModule


open class BaseActivity : AppCompatActivity(), MvpView {

    private var progressBar: ProgressBar? = null

    private lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent((application as App).getComponent())
                .build()

    }

    fun getActivityComponent() : ActivityComponent = activityComponent

    override fun showLoding() {
        hideLoading()

        progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleLarge)

        val params = RelativeLayout.LayoutParams(100, 100)
        params.addRule(RelativeLayout.CENTER_IN_PARENT)

        (window.decorView.rootView as ViewGroup).addView(progressBar, params)
        progressBar?.visibility = View.VISIBLE
    }

    override fun disableInteraction() {
        window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    override fun enableInteraction() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    override fun hideLoading() {
        progressBar?.visibility = View.GONE
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}