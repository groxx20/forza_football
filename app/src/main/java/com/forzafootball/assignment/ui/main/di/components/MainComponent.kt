package com.forzafootball.assignment.ui.main.di.components

import com.forzafootball.assignment.di.components.AppComponent
import com.forzafootball.assignment.ui.main.MainActivity
import com.forzafootball.assignment.ui.main.di.modules.MainModule
import com.forzafootball.assignment.ui.main.di.scopes.MainScope
import dagger.Component

/**
 * Created by pavel on 25/1/18.
 */
@MainScope
@Component(dependencies = [AppComponent::class], modules = [MainModule::class])
interface MainComponent{

    fun inject(mainActivity: MainActivity)
}