/**
 * @author by Kiet-Ngo
 * @day 21/09/2020
 * */
package com.example.restapi.rest.api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restapi.databinding.FragmentRestApiBinding

class RestApiFragment : Fragment() {
    private lateinit var binding : FragmentRestApiBinding
    private lateinit var restApiAdapter: RestApiAdapter
    private val viewModel : RestApiViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRestApiBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        restApiAdapter = RestApiAdapter()
        viewModel.listCountry.observe(viewLifecycleOwner, {list ->
            restApiAdapter.submitList(list)
        })
        binding.listCountry.apply {
            adapter = restApiAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}

