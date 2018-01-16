package ru.batonec.skeleton.ui.main

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_main_2.*
import ru.batonec.skeleton.R
import ru.batonec.skeleton.ScreenKeys
import ru.batonec.skeleton.di.DependencyManager
import ru.batonec.skeleton.presentation.main.MainPresenter
import ru.batonec.skeleton.presentation.main.MainView
import ru.batonec.skeleton.ui.base.BaseActivity

class MainActivity : BaseActivity(), MainView {

    @InjectPresenter lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btnPerformTask.setOnClickListener { presenter.performTask() }
        btnLogout.setOnClickListener { presenter.logout() }
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        btnPerformTask.isEnabled = false
    }

    override fun navigateToScreen(key: String, args: Bundle?) {
        when (key) {
            ScreenKeys.LaunchScreen -> finish()
        }
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
        btnPerformTask.isEnabled = true
    }

    override val layoutResource = R.layout.activity_main_2

    @ProvidePresenter
    fun providePresenter(): MainPresenter {
        val presenter = DependencyManager.openMainComponent().mainPresenter()
        DependencyManager.closeMainComponent()
        return presenter
    }
}