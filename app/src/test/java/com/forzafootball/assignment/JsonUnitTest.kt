package com.forzafootball.assignment

import com.forzafootball.assignment.dbdata.db.TeamDB
import com.forzafootball.assignment.network.NetworkService
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.nhaarman.mockito_kotlin.whenever
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import rx.Observable
import rx.observers.TestSubscriber


/**
 * Created by pavel on 7/2/18.
 */

class JsonUnitTest {

    private val string = "[\n" +
            "    {\n" +
            "        \"name\": \"Arsenal FC\",\n" +
            "        \"national\": false,\n" +
            "        \"country_name\": \"England\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"FC Barcelona\",\n" +
            "        \"national\": false,\n" +
            "        \"country_name\": \"Spain\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Sweden\",\n" +
            "        \"national\": true,\n" +
            "        \"country_name\": \"Sweden\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Inter Milan\",\n" +
            "        \"national\": false,\n" +
            "        \"country_name\": \"Italy\"\n" +
            "    }\n" +
            "]"

    @Mock
    private lateinit var service: NetworkService

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

    }

    @Test
    fun test_service() {

        val body = ResponseBody.create(MediaType.parse("text/plain"), string)

        whenever(service.providesTeams()).
                thenReturn(Observable.just(body))

        val result = service.providesTeams()
        val testSubscriber = TestSubscriber<ResponseBody>()
        result.subscribe(testSubscriber)

        testSubscriber.assertNoErrors()
        testSubscriber.assertValueCount(1)
        testSubscriber.assertValue(body)
        testSubscriber.assertCompleted()

        val gson = GsonBuilder().setPrettyPrinting().create()
        val teamList: List<TeamDB> = gson.fromJson(testSubscriber.onNextEvents[0].string(), object : TypeToken<List<TeamDB>>() {}.type)

        assert(teamList[0].name == "Arsenal FC")
        assert(teamList[0].country_name == "England")
        assert(teamList[0].national == false)

        assert(teamList[0].name == "FC Barcelona")
        assert(teamList[0].country_name == "Spain")
        assert(teamList[0].national == false)

        assert(teamList[0].name == "Sweden")
        assert(teamList[0].country_name == "Sweden")
        assert(teamList[0].national == true)

    }




}