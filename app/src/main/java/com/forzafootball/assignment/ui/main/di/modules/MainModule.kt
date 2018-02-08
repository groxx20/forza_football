package com.forzafootball.assignment.ui.main.di.modules

import com.forzafootball.assignment.ui.main.MainPresenterImpl
import com.forzafootball.assignment.ui.main.MainView
import com.forzafootball.assignment.ui.main.di.scopes.MainScope
import dagger.Module
import dagger.Provides

/**
 * Created by pavel on 25/1/18.
 */

@Module
class MainModule( private val mainView: MainView) {


    @Provides
    @MainScope
    fun providesView(): MainView {
        return  mainView
    }

    @Provides
    @MainScope
    fun providesMainPresenter(mainView: MainView) : MainPresenterImpl {
        return MainPresenterImpl(mainView)
    }
}