package com.forzafootball.assignment.ui.splash.di.modules

import com.forzafootball.assignment.service.GeneralService
import com.forzafootball.assignment.service.IGeneralService
import com.forzafootball.assignment.ui.splash.SplashPresenterImpl
import com.forzafootball.assignment.ui.splash.SplashView
import com.forzafootball.assignment.ui.splash.di.scopes.SplashScope
import dagger.Module
import dagger.Provides


/**
 * Created by pavel on 5/2/18.
 */

@Module
class SplashModule(private val splashView: SplashView){


    @Provides
    @SplashScope
    fun providesView(): SplashView{
        return  splashView
    }

    @Provides
    @SplashScope
    fun providesGeneralService(): IGeneralService {
        return GeneralService()
    }


    @Provides
    @SplashScope
    fun providesSplashPresenter(iGeneralService: IGeneralService, splashView: SplashView) : SplashPresenterImpl {
        return SplashPresenterImpl(iGeneralService, splashView)
    }

}