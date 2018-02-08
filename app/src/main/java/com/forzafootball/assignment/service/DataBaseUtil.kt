package com.forzafootball.assignment.service

import com.forzafootball.assignment.dbdata.DataBaseProvider
import com.forzafootball.assignment.dbdata.db.TeamDB

/**
 * Created by pavel on 6/2/18.
 */
class DataBaseUtil {

    companion object {
        fun saveTeams(teams: List<TeamDB>){

            for(teamDB: TeamDB in teams) {
                DataBaseProvider.insertTeam(teamDB)
            }
        }

        fun removeTeams(){
            DataBaseProvider.deleteAllTeams()
        }
    }


}

