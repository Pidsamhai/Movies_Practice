/*
 * Create date 6/7/20 3:06 PM
 *
 * Copyright 2020 Pidsamhai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.psm.movies.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.github.psm.movies.adapter.MovieListAdapter
import com.github.psm.movies.databinding.FragmentMovieListBinding
import com.github.psm.movies.ui.viewmodel.MovieListViewModel
import com.github.psm.movies.utils.InjectUtils

class MovieFragment : Fragment() {

    private val viewModel:MovieListViewModel by viewModels {
        InjectUtils.provideMovieListViewModelFactory(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMovieListBinding.inflate(inflater,container,false)
        context ?: binding.root

        val adapter = MovieListAdapter()
        binding.movieList.adapter = adapter
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun subscribeUi(adapter: MovieListAdapter) {
        viewModel.movies.observe(viewLifecycleOwner, Observer {
            Log.i("Observe",  it.toString())
            it?.let {
                adapter.submitList(it)
            }
        })
    }
}