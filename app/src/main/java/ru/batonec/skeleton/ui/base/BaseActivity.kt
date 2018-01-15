package ru.batonec.skeleton.ui.base

import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity

abstract class BaseActivity : MvpAppCompatActivity() {

    abstract val layoutResource: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource)
    }

    open fun toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT)
}