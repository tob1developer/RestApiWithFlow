/**
 * @author by Kiet-Ngo
 * @day 21/09/2020
 * */
package com.example.restapi.model

import com.google.gson.annotations.SerializedName

data class Global(
    @SerializedName("NewConfirmed")
    val newConfirmed: Long,
    @SerializedName("TotalConfirmed")
    val totalConfirmed: Long,
    @SerializedName("NewDeath")
    val newDeath: Long,
    @SerializedName("TotalDeath")
    val totalDeath: Long,
    @SerializedName("NewRecovered")
    val newRecovered: Long,
    @SerializedName("TotalRecovered")
    val totalRecovered: Long
)