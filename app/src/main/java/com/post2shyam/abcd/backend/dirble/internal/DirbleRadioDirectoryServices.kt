package com.post2shyam.abcd.backend.dirble.internal

import com.post2shyam.abcd.backend.dirble.interactions.response.PopularStationsRsp
import io.reactivex.Observable
import retrofit2.http.GET

const val DIRBLE_BASE_URL = "http://api.dirble.com/v2/"

interface DirbleRadioDirectoryServices {
  @GET("stations/popular")
  fun popularStations(): Observable<Array<PopularStationsRsp>>
}