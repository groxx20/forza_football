package com.forzafootball.assignment.dbdata

import com.forzafootball.assignment.dbdata.db.TeamDB

/**
 * Created by pavel on 6/2/18.
 */

class DataBaseProvider{

    companion object {
        fun insertTeam(team: TeamDB) {
            DBManager.getTeamDao().insert(team)
        }

        fun deleteAllTeams() {
            DBManager.getTeamDao().deleteAll()
        }

        fun getAllTeams(): List<TeamDB> {

            return DBManager.getTeamDao().loadAll()
        }
    }
}