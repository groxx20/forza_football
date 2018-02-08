package com.forzafootball.assignment.ui.splash

import com.forzafootball.assignment.network.data.NetworkError
import com.forzafootball.assignment.dbdata.db.TeamDB
import com.forzafootball.assignment.service.DataBaseUtil
import com.forzafootball.assignment.service.IGeneralService
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody

/**
 * Created by pavel on 5/2/18.
 */

    class SplashPresenterImpl(private val iGeneralService: IGeneralService, private  val  splashView: SplashView) : SplashPresenter, IGeneralService.OnGetVersionListener {


    /**
     *  Function to retrieve teams from backend
     */
    override fun getTeams() {
        splashView.showLoading()
        iGeneralService.getTeams(this)
    }

    /**
     *  Response from api
     */
    override fun onSuccess(responseBody: ResponseBody) {

        splashView.hideLoading()
        DataBaseUtil.removeTeams()
        storeInfo(responseBody.string())

    }

    /**
     *  Response from api
     */
    override fun onFailure(networkError: NetworkError) {

        splashView.hideLoading()
        splashView.onFailure(networkError.appErrorMessage)
        iGeneralService.cancelNetworkRequest()
    }

    /**
     *  Store info in database
     */
    private fun storeInfo( data: String){

        val gson = GsonBuilder().setPrettyPrinting().create()
        val teamList: List<TeamDB> = gson.fromJson(data, object : TypeToken<List<TeamDB>>() {}.type)

        DataBaseUtil.saveTeams(teamList)
        splashView.goNext()
    }


}
