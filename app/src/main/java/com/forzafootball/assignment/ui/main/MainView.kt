package com.forzafootball.assignment.ui.main

import com.forzafootball.assignment.dbdata.db.TeamDB

/**
 * Created by pavel on 5/2/18.
 */
interface MainView {

    fun showLoading()

    fun hideLoading()

    fun showStuff(teams: List<TeamDB>)

}