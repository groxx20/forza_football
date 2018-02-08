package com.forzafootball.assignment

import android.app.Application
import com.forzafootball.assignment.dbdata.DBManager
import com.forzafootball.assignment.di.components.AppComponent
import com.forzafootball.assignment.di.components.DaggerAppComponent

/**
 * Created by pavel on 22/1/18.
 */

class ForzaApp : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    /**
     * Init dagger app component
     */
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()

        initDatabase()
    }

    /**
     * Init database
     */
    private fun initDatabase() {

        DBManager.init(this)
    }
}