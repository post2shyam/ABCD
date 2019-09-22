package com.post2shyam.abcd.backend.radiobrowser

import com.post2shyam.abcd.backend.radiobrowser.response.RadioBrowserTopVotedRadioRsp
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

const val RADIO_BROWERSER_BASE_URL = "http://www.radio-browser.info/webservice/json/"

interface RadioBrowserDirectoryServices {
    ///////////// STATIONS - API ////////////////////
    // Stations by vote
    @GET("stations/topvote/{entryCount}")
    fun topVotedStations(@Path("entryCount") entryCount: String): Observable<Array<RadioBrowserTopVotedRadioRsp>>

}




