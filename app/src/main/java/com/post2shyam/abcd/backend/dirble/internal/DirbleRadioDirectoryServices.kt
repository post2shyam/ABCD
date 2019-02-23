package com.post2shyam.abcd.backend.dirble.internal

import com.post2shyam.abcd.backend.dirble.interactions.response.NewStationsRsp
import com.post2shyam.abcd.backend.dirble.interactions.response.PopularStationsRsp
import com.post2shyam.abcd.backend.dirble.interactions.response.StationsWithIdRsp
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

const val DIRBLE_BASE_URL = "http://api.dirble.com/v2/"

interface DirbleRadioDirectoryServices {
  //Get new added stations
  @GET("stations/recent")
  fun newAddedStations(): Observable<Array<NewStationsRsp>>

  //Get popular stations
  @GET("stations/popular")
  fun popularStations(): Observable<Array<PopularStationsRsp>>

  //Get a specific station
  @GET("station/{id}")
  fun getStationWithId(@Path("id") id: Int): Observable<StationsWithIdRsp>
}




