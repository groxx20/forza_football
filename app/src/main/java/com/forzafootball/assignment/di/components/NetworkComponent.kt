package com.forzafootball.assignment.di.components

import com.forzafootball.assignment.di.modules.NetworkModule
import com.forzafootball.assignment.di.scopes.PerService
import com.forzafootball.assignment.service.GeneralService
import dagger.Component

/**
 * Created by pavel on 24/1/18.
 */
@PerService
@Component(dependencies = [AppComponent::class], modules = [NetworkModule::class])
interface NetworkComponent{

    fun inject(generalService: GeneralService)
}