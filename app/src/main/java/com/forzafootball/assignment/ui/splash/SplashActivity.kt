package com.forzafootball.assignment.ui.splash

import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.forzafootball.assignment.ForzaApp
import com.forzafootball.assignment.R
import com.forzafootball.assignment.ui.main.MainActivity
import com.forzafootball.assignment.ui.splash.di.components.DaggerSplashComponent
import com.forzafootball.assignment.ui.splash.di.components.SplashComponent
import com.forzafootball.assignment.ui.splash.di.modules.SplashModule
import com.forzafootball.assignment.utils.goToActivity
import com.forzafootball.assignment.utils.toastError
import com.forzafootball.assignment.utils.toastSuccess
import kotlinx.android.synthetic.main.content_splash.*
import javax.inject.Inject


class SplashActivity : AppCompatActivity(), SplashView {

    @Inject
    lateinit var splashPresenterImpl: SplashPresenterImpl

    private lateinit var splashComponent: SplashComponent
    private var animation: Animation? = null
    private var animation2: Animation? = null
    private var countDownTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        injectDependencies()
        showAnimation()
    }

    /**
     *  Inject dependencies
     */
    private fun injectDependencies(){

        val appComponent = ForzaApp.appComponent

        splashComponent = DaggerSplashComponent.builder()
                .splashModule(SplashModule(this))
                .appComponent(appComponent)
                .build()
        splashComponent.inject(this)
    }

    /**
     *  Start of animation
     */
    private fun showAnimation(){

        animation = AnimationUtils.loadAnimation(this, R.anim.start_animation)
        animation2 = AnimationUtils.loadAnimation(this, R.anim.start_animation)

        imageLogo.startAnimation(animation)

        countDownTimer = object : CountDownTimer(2500,1000){
            override fun onFinish() {


                splashPresenterImpl.getTeams()
            }
            override fun onTick(p0: Long) {

                if(p0<2000){
                    titleTxt.visibility = View.VISIBLE
                    titleTxt.startAnimation(animation2)
                }
            }
        }.start()

    }


    override fun showLoading() {

        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {

        progressBar.visibility = View.INVISIBLE
    }

    /**
     *  Move to another activity
     */
    override fun goNext() {
        toastSuccess(resources.getString(R.string.success))
        goToActivity<MainActivity>()
        finish()
    }

    /**
     *  Shows error message
     */
    override fun onFailure(msg: String) {
        toastError(msg)
    }


}
