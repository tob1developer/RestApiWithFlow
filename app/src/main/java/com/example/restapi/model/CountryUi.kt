/**
 * @author by Kiet-Ngo
 * @day 21/09/2020
 * */
package com.example.restapi.model

data class CountryUi(
    val country: Country,
    val onClick : () -> Unit
)