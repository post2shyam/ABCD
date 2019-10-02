package com.post2shyam.reverbuzzy.backend.radiobrowser

import com.post2shyam.reverbuzzy.backend.radiobrowser.response.RadioBrowserCountryCodesRsp
import com.post2shyam.reverbuzzy.backend.radiobrowser.response.RadioBrowserLanguageRsp
import com.post2shyam.reverbuzzy.backend.radiobrowser.response.RadioBrowserPlayableStationRsp
import com.post2shyam.reverbuzzy.backend.radiobrowser.response.RadioBrowserRadioStationRsp
import com.post2shyam.reverbuzzy.backend.radiobrowser.response.RadioBrowserStatesRsp
import com.post2shyam.reverbuzzy.backend.radiobrowser.response.RadioBrowserTagsRsp
import com.post2shyam.reverbuzzy.backend.radiobrowser.response.RadioBrowserVoteRsp
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

const val RADIO_BROWERSER_BASE_URL = "http://www.radio-browser.info/webservice/json/"

interface RadioBrowserDirectoryServices {

  //List APIs
  //Get all country codes
  @GET("countrycodes")
  fun getAllCountryCodes(): Observable<Array<RadioBrowserCountryCodesRsp>>

  //Get states (of a country)
  @FormUrlEncoded
  @POST("states/{countryCode}")
  fun getStatesWithCountry(
    @Field("reverse") reverse: Boolean,
    @Field("hidebroken") showBrokenStations: Boolean,
    @Path("countryCode") countryCode: String
  ): Observable<Array<RadioBrowserStatesRsp>>

  //Get all languages
  @FormUrlEncoded
  @POST("languages")
  fun getAllLanguages(
    @Field("reverse") reverse: Boolean,
    @Field("hidebroken") showBrokenStations: Boolean
  ): Observable<Array<RadioBrowserLanguageRsp>>

  //Get all tags
  @FormUrlEncoded
  @POST("tags")
  fun getAllTags(
    @Field(
        "hidebroken"
    ) isBrokenHidden: Boolean
  ): Observable<Array<RadioBrowserTagsRsp>>

  //Station APIS
  // Get stations by max vote
  @GET("stations/topvote/{entryCount}")
  fun topVotedStations(
    @Path(
        "entryCount"
    ) entryCount: String
  ): Observable<Array<RadioBrowserRadioStationRsp>>

  //Stations by tag
  @FormUrlEncoded
  @POST("stations/tag/{tag}")
  fun getStationListByTag(
    @Field("reverse") inReverseOrder: Boolean,
    @Field("offset") startOffset: Int,
    @Field("limit") itemCount: Int,
    @Path("tag") genre: String
  ): Observable<Array<RadioBrowserRadioStationRsp>>

  //Get playable station url
  @GET("url/{url/stationid}")
  fun getPlayableStationUrl(
    @Path(
        "stationid"
    ) stationId: String
  ): Observable<RadioBrowserPlayableStationRsp>

  //Modify APIs
  //Vote for station
  @GET("vote/{stationId}")
  fun voteForStation(@Path("stationId") stationId: String): Observable<RadioBrowserVoteRsp>

}




