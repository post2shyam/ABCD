package com.post2shyam.reverbuzzy.backend.radiobrowser

import com.post2shyam.reverbuzzy.backend.radiobrowser.response.*
import io.reactivex.Observable
import retrofit2.http.*

const val RADIO_BROWERSER_BASE_URL = "http://www.radio-browser.info/webservice/"

interface RadioBrowserDirectoryServices {

  //List APIs
  //Get all country codes
  @GET("json/countrycodes")
  fun getAllCountryCodes(): Observable<Array<RadioBrowserCountryCodesRsp>>

  //Get states (of a country)
  @FormUrlEncoded
  @POST("json/states/{countryCode}")
  fun getStatesWithCountry(
    @Field("reverse") reverse: Boolean,
    @Field("hidebroken") showBrokenStations: Boolean,
    @Path("countryCode") countryCode: String
  ): Observable<Array<RadioBrowserStatesRsp>>

  //Get all languages
  @FormUrlEncoded
  @POST("json/languages")
  fun getAllLanguages(
    @Field("reverse") reverse: Boolean,
    @Field("hidebroken") showBrokenStations: Boolean
  ): Observable<Array<RadioBrowserLanguageRsp>>

  //Get all tags
  @FormUrlEncoded
  @POST("json/tags")
  fun getAllTags(
    @Field(
        "hidebroken"
    ) isBrokenHidden: Boolean
  ): Observable<Array<RadioBrowserTagsRsp>>

  //Station APIS
  // Get stations by max vote
  @GET("json/stations/topvote/{entryCount}")
  fun topVotedStations(
    @Path(
        "entryCount"
    ) entryCount: String
  ): Observable<Array<RadioBrowserRadioStationRsp>>

  //Stations
  @FormUrlEncoded
  @POST("json/stations/search")
  fun getStationList(
    @Field("reverse") inReverseOrder: Boolean,
    @Field("tag") tag: String,
    @Field("offset") startOffset: Int,
    @Field("limit") itemCount: Int
  ): Observable<Array<RadioBrowserRadioStationRsp>>

  //Get playable station url
  @GET("v2/json/url/{stationid}")
  fun getPlayableStationUrl(
    @Path(
        "stationid"
    ) stationId: String
  ): Observable<RadioBrowserPlayableStationRsp>

  //Modify APIs
  //Vote for station
  @GET("json/vote/{stationId}")
  fun voteForStation(@Path("stationId") stationId: String): Observable<RadioBrowserVoteRsp>

}




