package ru.batonec.skeleton.ui.launch

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_main.*
import ru.batonec.skeleton.App
import ru.batonec.skeleton.R
import ru.batonec.skeleton.presentation.launch.LaunchPresenter
import ru.batonec.skeleton.presentation.launch.LaunchView
import ru.batonec.skeleton.ui.base.BaseActivity

class LaunchActivity : BaseActivity(), LaunchView {
    override val layoutResource = R.layout.activity_main

    @InjectPresenter lateinit var presenter: LaunchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btnHello.setOnClickListener { presenter.performLongTask() }
    }

    override fun showInfo(info: String) {
        txtHello.text = info
    }

    override fun showError(error: String) {
        toast(error)
    }

    override fun showProgress() {
        txtHello.visibility = View.INVISIBLE
        btnHello.visibility = View.INVISIBLE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        txtHello.visibility = View.VISIBLE
        btnHello.visibility = View.VISIBLE
        progressBar.visibility = View.INVISIBLE
    }

    @ProvidePresenter
    fun providePresenter() = App.appComponent.launchPresenter()
}