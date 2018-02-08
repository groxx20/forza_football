package com.forzafootball.assignment.utils

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import com.forzafootball.assignment.R
import com.shashank.sony.fancytoastlib.FancyToast


/**
* Created by pavel on 5/2/18.
*/

// Extension for Activity Intents
inline  fun <reified  T : Activity> Activity.goToActivity(init: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    intent.init()
    startActivity(intent)
    overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out)
}

// Extension for Fancy Default
fun Activity.toastSuccess(message: String, duration: Int = Toast.LENGTH_SHORT) = FancyToast.makeText(this, message, duration, FancyToast.SUCCESS, false)!!.show()

// Extension for Fancy Default
fun Activity.toastError(message: String, duration: Int = Toast.LENGTH_SHORT) = FancyToast.makeText(this, message, duration, FancyToast.ERROR, false)!!.show()
