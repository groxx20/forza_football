package com.forzafootball.assignment.ui.main

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.forzafootball.assignment.ForzaApp
import com.forzafootball.assignment.R
import com.forzafootball.assignment.adapter.TeamAdapter
import com.forzafootball.assignment.dbdata.db.TeamDB
import com.forzafootball.assignment.service.DataBaseService
import com.forzafootball.assignment.ui.main.di.components.DaggerMainComponent
import com.forzafootball.assignment.ui.main.di.components.MainComponent
import com.forzafootball.assignment.ui.main.di.modules.MainModule
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

open class MainActivity : AppCompatActivity(), MainView {


    private lateinit var mainComponent: MainComponent
    private var teamAdapter: TeamAdapter? = null
    private var teams: List<TeamDB>? = null
    var dataBaseService: DataBaseService? = null
    var isBound = false


    @Inject
    lateinit var mainPresenter: MainPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectComponent()
        setupRecyclerView(rvTeams)

        mainPresenter.startLoading()
    }

    /**
     *  Inject Dagger Dependencies
     */

    private fun injectComponent(){
        val appComponent = ForzaApp.appComponent

        mainComponent = DaggerMainComponent.builder()
                .mainModule(MainModule(this))
                .appComponent(appComponent)
                .build()
        mainComponent.inject(this)
    }

    override fun showLoading() { progressBar.visibility = View.VISIBLE }

    override fun hideLoading() { progressBar.visibility = View.INVISIBLE }

    /**
     *  Fill recyclerview with items
     */
    override fun showStuff(teams : List<TeamDB>) {

        teamAdapter = TeamAdapter( teams, this)
        rvTeams.adapter = teamAdapter
    }

    /**
     *  Layout manager for RecyclerView
     */
    private fun setupRecyclerView(recyclerView: RecyclerView) {

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

    }

    /**
     *  Binding the service
     */

    private val myConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName,
                                        service: IBinder) {
            val binder = service as DataBaseService.LocalService
            dataBaseService = binder.getService()
            isBound = true

            teams = dataBaseService?.getTeams()
            mainPresenter.hideLoading()
            showStuff(teams!!)
        }

        override fun onServiceDisconnected(name: ComponentName) {
            isBound = false
        }
    }

    override fun onStart() {
        super.onStart()
        val intent = Intent(this, DataBaseService::class.java)
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onStop() {
        super.onStop()
        if (isBound) {
            unbindService(myConnection)
        }
    }
}
