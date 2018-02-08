package com.forzafootball.assignment.service

import com.forzafootball.assignment.ForzaApp
import com.forzafootball.assignment.network.data.NetworkError
import com.forzafootball.assignment.di.components.DaggerNetworkComponent
import com.forzafootball.assignment.di.modules.NetworkModule
import com.forzafootball.assignment.network.NetworkService
import okhttp3.ResponseBody
import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by pavel on 23/1/18.
 */
class GeneralService : IGeneralService {


    var appComponent = ForzaApp.appComponent

    private var subscription: Subscription? = null

    @Inject
    lateinit var networkService: NetworkService

    /**
     *  Inject network module
     */
    init {
        DaggerNetworkComponent.builder()
                .networkModule(NetworkModule())
                .appComponent(appComponent)
                .build()
                .inject(this)
    }


    /**
     * RxJava method to get teams
     */
    override fun getTeams(listener: IGeneralService.OnGetVersionListener){

        subscription = networkService.providesTeams()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext { throwable -> Observable.error(throwable) }
                .subscribe(object : Subscriber<ResponseBody>() {
                    override fun onCompleted() {

                    }

                    override fun onError(e: Throwable) {
                        listener.onFailure(NetworkError(e))
                    }

                    override fun onNext(responseBody: ResponseBody) {
                        listener.onSuccess(responseBody)
                    }
                })

    }

    /**
     * Cancel subscription
     */
    override fun cancelNetworkRequest() {
        subscription?.unsubscribe()
    }

}