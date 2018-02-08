package com.forzafootball.assignment.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.support.annotation.Nullable
import com.forzafootball.assignment.dbdata.DataBaseProvider
import com.forzafootball.assignment.dbdata.db.TeamDB


/**
 * Created by pavel on 7/2/18.
 */


class DataBaseService : Service() {
    private val mBinder = LocalService()

    @Nullable
    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    inner class LocalService : Binder() {
        fun getService(): DataBaseService {
            return this@DataBaseService
        }
    }

    fun getTeams(): List<TeamDB>{
        return DataBaseProvider.getAllTeams()
    }
}