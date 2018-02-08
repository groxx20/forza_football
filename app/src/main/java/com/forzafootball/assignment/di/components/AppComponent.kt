package com.forzafootball.assignment.di.components

import com.forzafootball.assignment.ForzaApp
import com.forzafootball.assignment.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by pavel on 22/1/18.
 */

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent{


    fun inject(app: ForzaApp)

}