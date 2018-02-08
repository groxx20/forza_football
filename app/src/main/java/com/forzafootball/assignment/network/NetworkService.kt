package com.forzafootball.assignment.network

import com.forzafootball.assignment.utils.Constants
import okhttp3.ResponseBody
import retrofit2.http.GET
import rx.Observable

/**
 * Created by pavel on 23/1/18.
 */
interface NetworkService {

    @GET(Constants.API_TEAMS)
    fun providesTeams() : Observable<ResponseBody>
}