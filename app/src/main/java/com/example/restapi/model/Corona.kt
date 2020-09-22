/**
 * @author by Kiet-Ngo
 * @day 21/09/2020
 * */
package com.example.restapi.model

import com.google.gson.annotations.SerializedName

data class Corona(
    @SerializedName("Message")
    val message: String,
    @SerializedName("Global")
    val global: Global,
    @SerializedName("Countries")
    val listCountry: List<Country>,
    @SerializedName("Date")
    val date : String
)