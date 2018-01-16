package ru.batonec.skeleton.ui.launch

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_main.*
import ru.batonec.skeleton.R
import ru.batonec.skeleton.ScreenKeys
import ru.batonec.skeleton.di.DependencyManager
import ru.batonec.skeleton.presentation.launch.LaunchPresenter
import ru.batonec.skeleton.presentation.launch.LaunchView
import ru.batonec.skeleton.ui.base.BaseActivity
import ru.batonec.skeleton.ui.main.MainActivity

class LaunchActivity : BaseActivity(), LaunchView {
    override val layoutResource = R.layout.activity_main

    @InjectPresenter lateinit var presenter: LaunchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btnHello.setOnClickListener { presenter.performLongTask() }
    }

    override fun showError(error: String) {
        toast(error)
    }

    override fun showProgress() {
        btnHello.visibility = View.INVISIBLE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        btnHello.visibility = View.VISIBLE
        progressBar.visibility = View.INVISIBLE
    }

    override fun navigateToScreen(key: String, args: Bundle?) {
        when (key) {
            ScreenKeys.MainScreen -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    @ProvidePresenter
    fun providePresenter(): LaunchPresenter {
        val presenter = DependencyManager.openLaunchComponent().launchPresenter()
        DependencyManager.closeLaunchComponent()
        return presenter
    }
}