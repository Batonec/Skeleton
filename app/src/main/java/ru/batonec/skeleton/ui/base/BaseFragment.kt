package ru.batonec.skeleton.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment

abstract class BaseFragment : MvpAppCompatFragment() {

    abstract val layoutResource: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
            = inflater.inflate(layoutResource, container, false)
}