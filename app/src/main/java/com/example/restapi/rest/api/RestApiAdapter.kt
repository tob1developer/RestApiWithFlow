/**
 * @author by Kiet-Ngo
 * @day 21/09/2020
 * */
package com.example.restapi.rest.api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.R
import com.example.restapi.databinding.ItemCountryBinding
import com.example.restapi.model.Country
import com.example.restapi.model.CountryUi

class RestApiAdapter : ListAdapter<CountryUi, RestApiAdapter.RestApiViewHolder>(RestApiDiffUtil){

    inner class RestApiViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val tvCountry : TextView = itemView.findViewById(R.id.tvCountry)
        private val tvShowDate : TextView = itemView.findViewById(R.id.tvShowDate)
        private val tvSHowTotalDeath: TextView = itemView.findViewById(R.id.tvSHowTotalDeath)
        private val tvShowTotalConfirmed: TextView = itemView.findViewById(R.id.tvShowTotalConfirmed)

        fun bind(country: CountryUi){
            tvCountry.text = country.country.country
            tvShowDate.text = country.country.date
            tvSHowTotalDeath.text = country.country.totalDeath.toString()
            tvShowTotalConfirmed.text = country.country.totalConfirmed.toString()

            itemView.setOnClickListener {
                country.onClick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestApiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country,parent,false)
        return RestApiViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestApiViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object RestApiDiffUtil: DiffUtil.ItemCallback<CountryUi>() {
        override fun areItemsTheSame(oldItem: CountryUi, newItem: CountryUi): Boolean {
            return oldItem.country == newItem.country
        }

        override fun areContentsTheSame(oldItem: CountryUi, newItem: CountryUi): Boolean {
            return oldItem == newItem
        }

    }

}