package com.forzafootball.assignment

import com.forzafootball.assignment.network.NetworkService
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import rx.observers.TestSubscriber


/**
 * Created by pavel on 7/2/18.
 */

class ServiceUnitTest {

    private var retrofit: Retrofit? = null
    var mSubscriber: TestSubscriber<ResponseBody>? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

         retrofit = Retrofit.Builder().baseUrl("https://s3-eu-west-1.amazonaws.com/")
                 .client(OkHttpClient())
                 .addConverterFactory(GsonConverterFactory.create())
                 .addConverterFactory(ScalarsConverterFactory.create())
                 .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                 .build()


        mSubscriber = TestSubscriber()

    }



    @Test
    fun service_Success() {

        val apiEndpoints = retrofit!!.create(NetworkService::class.java)

        apiEndpoints.providesTeams().subscribe(mSubscriber)


        mSubscriber!!.assertNoErrors()
        mSubscriber!!.assertCompleted()


    }


}