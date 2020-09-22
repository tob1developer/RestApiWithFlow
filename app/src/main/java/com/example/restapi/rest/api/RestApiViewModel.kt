package com.example.restapi.rest.api

import android.util.Log
import androidx.lifecycle.*
import com.example.restapi.model.Corona
import com.example.restapi.model.Country
import com.example.restapi.model.CountryUi
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class RestApiViewModel: ViewModel() {
    private val _listCountry = MutableLiveData<List<Country>>()
    val listCountry : LiveData<List<CountryUi>> = _listCountry.map {
        it.map { countryOnList ->
            CountryUi(
                country = countryOnList,
                onClick = {
                    //TODO:...
                }
            )
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            //okHttp3
            val client: OkHttpClient = OkHttpClient().newBuilder()
                .build()
            val request =  Request.Builder()
                .url("https://api.covid19api.com/summary")
                .method("GET", null)
                .build()
            val response: Response = client.newCall(request).execute()
            val json = response.body()?.string()

            //Gson
            val corona : Corona? = Gson().fromJson(json, Corona::class.java)

            _listCountry.postValue(corona?.listCountry)
        }
    }

}