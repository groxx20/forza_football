package com.forzafootball.assignment.service

import com.forzafootball.assignment.network.data.NetworkError
import okhttp3.ResponseBody

/**
 * Created by pavel on 24/1/18.
 */
interface IGeneralService {

    interface OnGetVersionListener {
        fun onSuccess(responseBody: ResponseBody)
        fun onFailure(networkError: NetworkError)
    }

    fun getTeams(listener: OnGetVersionListener)

    fun cancelNetworkRequest()

}