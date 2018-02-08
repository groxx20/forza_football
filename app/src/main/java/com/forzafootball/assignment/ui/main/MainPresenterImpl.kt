package com.forzafootball.assignment.ui.main

/**
 * Created by pavel on 24/1/18.
 */

class MainPresenterImpl(private val mainView: MainView): MainPresenter{

    override fun startLoading(){
        mainView.showLoading()
    }

    override fun hideLoading(){
        mainView.hideLoading()
    }
}