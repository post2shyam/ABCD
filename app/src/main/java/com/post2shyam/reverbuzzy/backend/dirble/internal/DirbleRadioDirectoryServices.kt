package com.post2shyam.reverbuzzy.backend.dirble.internal

import com.post2shyam.reverbuzzy.backend.dirble.interactions.response.AllSongCategoriesAsTreeRsp
import com.post2shyam.reverbuzzy.backend.dirble.interactions.response.ContinentListRsp
import com.post2shyam.reverbuzzy.backend.dirble.interactions.response.CountryListRsp
import com.post2shyam.reverbuzzy.backend.dirble.interactions.response.NewStationsRsp
import com.post2shyam.reverbuzzy.backend.dirble.interactions.response.PopularStationsRsp
import com.post2shyam.reverbuzzy.backend.dirble.interactions.response.SimilarStationsToIdRsp
import com.post2shyam.reverbuzzy.backend.dirble.interactions.response.SongHistoryOfStationRsp
import com.post2shyam.reverbuzzy.backend.dirble.interactions.response.StationsWithCategoryRsp
import com.post2shyam.reverbuzzy.backend.dirble.interactions.response.StationsWithIdRsp
import com.post2shyam.reverbuzzy.backend.dirble.interactions.response.WorldWideRecentPlayedSongsRsp
import com.post2shyam.reverbuzzy.backend.dirble.interactions.response.models.Category
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val DIRBLE_BASE_URL = "http://api.dirble.com/v2/"

interface DirbleRadioDirectoryServices {
    ///////////// STATIONS - API ////////////////////
    //Get new added stations
    @GET("stations/recent")
    fun newAddedStations(): Observable<Array<NewStationsRsp>>

    //Get popular stations
    @GET("stations/popular")
    fun popularStations(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("offset") offset: Int
    ): Observable<Array<PopularStationsRsp>>

    //Get a specific station
    @GET("station/{id}")
    fun getStationWith(@Path("id") id: Int): Observable<StationsWithIdRsp>

    //Get similar stations
    @GET("station/{id}/similar")
    fun getStationSimilarTo(@Path("id") id: Int): Observable<Array<SimilarStationsToIdRsp>>

    //Get song history of station
    @GET("station/{id}/song_history")
    fun getSongHistoryOfStation(@Path("id") id: Int): Observable<Array<SongHistoryOfStationRsp>>

    ////////////// SONGS - API   ///////////////////
    //Get world-wide recent played songs
    @GET("songs")
    fun getWorldWideRecentPlayedSongs(): Observable<Array<WorldWideRecentPlayedSongsRsp>>

    ////////////  CATEGORIES - API ////////////////
    //Get all categories
    @GET("categories")
    fun getAllSongCategories(): Observable<Array<Category>>

    //Get primary categories
    @GET("categories/primary")
    fun getPrimarySongCategories(): Observable<Array<Category>>

    //Get child categories of
    @GET("category/{categoryId}/childs")
    fun getChildCategoriesOf(
        @Path("categoryId") categoryId: Int,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("offset") offset: Int
    ): Observable<Array<Category>>

    //Get all category tree
    @GET("categories/tree")
    fun getAllSongCategoriesAsTree(): Observable<Array<AllSongCategoriesAsTreeRsp>>

    //Get stations belonging to a particular category
    @GET("category/{categoryId}/stations")
    fun getStationsForCategory(
        @Path("categoryId") categoryId: Int,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("offset") offset: Int
    ): Observable<Array<StationsWithCategoryRsp>>

    ////////////  Countries - API ////////////////

    //Get all countries
    @GET("countries")
    fun getCountryList(): Observable<Array<CountryListRsp>>

    //Get all continents
    @GET("continents")
    fun getContinentList(): Observable<Array<ContinentListRsp>>

    //Get countries in continent
    @GET("continents/{continentId}/countries")
    fun getCountryListForContinent(
        @Path("continentId") continentId: Int,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("offset") offset: Int
    ): Observable<Array<CountryListRsp>>

    //Get all stations of country
    @GET("countries/{countryCode}/stations")
    fun getAllStationOfCountry(
        @Path("countryCode") countryCode: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("offset") offset: Int
    ): Observable<Array<PopularStationsRsp>>
}




