/**
 * @author by Kiet-Ngo
 * @day 21/09/2020
 * */
package com.example.restapi.model

import com.google.gson.annotations.SerializedName


data class Country(
    @SerializedName("Country")
    val country : String,
    @SerializedName("CountryCode")
    val countryCode: String,
    @SerializedName("Slug")
    val slug : String,
    @SerializedName("NewConfirmed")
    val newConfirmed: Int,
    @SerializedName("TotalConfirmed")
    val totalConfirmed: Long,
    @SerializedName("NewDeath")
    val newDeath : Int,
    @SerializedName("TotalDeaths")
    val totalDeath: Long,
    @SerializedName("NewRecovered")
    val newRecovered: Int,
    @SerializedName("TotalRecovered")
    val TotalRecovered: Long,
    @SerializedName("Date")
    val date: String,
)
