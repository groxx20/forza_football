package com.forzafootball.assignment.ui.splash

/**
 * Created by pavel on 5/2/18.
 */
interface SplashView {

    fun showLoading()

    fun hideLoading()

    fun goNext()

    fun onFailure(msg:String)
}