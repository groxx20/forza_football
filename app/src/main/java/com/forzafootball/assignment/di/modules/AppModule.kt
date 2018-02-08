package com.forzafootball.assignment.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.forzafootball.assignment.ForzaApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by pavel on 22/1/18.
 */

@Module
class AppModule (private val mApp: ForzaApp){

    @Singleton
    @Provides
    fun provideContext(): Context {
        return mApp
    }

    @Singleton
    @Provides
    fun provideApplication(): ForzaApp {
        return mApp
    }
}