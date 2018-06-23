package com.example.hackett001.myapplication.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*
import com.example.hackett001.myapplication.App
import com.example.hackett001.myapplication.R
import com.example.hackett001.myapplication.di.component.ActivityComponent
import com.example.hackett001.myapplication.di.component.DaggerActivityComponent
import com.example.hackett001.myapplication.di.module.ActivityModule
import java.lang.reflect.Parameter


open class BaseActivity : AppCompatActivity(), MvpView {

    private var progressLayout: FrameLayout? = null

    private lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent((application as App).getComponent())
                .build()

    }

    fun getActivityComponent(): ActivityComponent = activityComponent

    override fun showLoding() {
        hideLoading()

        if (progressLayout == null)
            progressLayout = layoutInflater.inflate(R.layout.item_progress_bar, progressLayout) as FrameLayout

        (window.decorView as ViewGroup).addView(progressLayout)
        progressLayout?.visibility = View.VISIBLE
    }

    override fun disableInteraction() {
        window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    override fun enableInteraction() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    override fun hideLoading() {
        progressLayout?.visibility = View.GONE
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}