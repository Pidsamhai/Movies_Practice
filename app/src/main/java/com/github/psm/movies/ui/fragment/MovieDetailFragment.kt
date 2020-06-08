/*
 * Create date 6/8/20 5:26 PM
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
import androidx.core.widget.NestedScrollView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.github.psm.movies.R
import com.github.psm.movies.data.Movie
import com.github.psm.movies.databinding.FragmentMovieDetailBinding
import com.github.psm.movies.ui.viewmodel.MovieDetailViewModel
import com.github.psm.movies.utils.InjectUtils

class MovieDetailFragment : Fragment() {

    private val args: MovieDetailFragmentArgs by navArgs()
    val movieDetailViewModel: MovieDetailViewModel by viewModels {
        InjectUtils.provideMovieDetailViewModelFactory(args.movieID, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMovieDetailBinding>(
            inflater,
            R.layout.fragment_movie_detail,
            container,
            false
        ).apply {
            viewModel = movieDetailViewModel
            lifecycleOwner = viewLifecycleOwner
            callback = object : Callback{
                override fun addToFavorite(movie: Movie) {

                }
            }

            var isToolbarShow = false

            movieScrollView.setOnScrollChangeListener(
                NestedScrollView.OnScrollChangeListener{ _, _, scrollY, _, _ ->
                    Log.i("scrollY ",scrollY.toString() + " H ${toolbar.height}")
                    val showToolbar =  scrollY > toolbar.height
                    if (isToolbarShow != showToolbar) {
                        isToolbarShow = showToolbar
                        appBar.isActivated = showToolbar
                        movieCollapse.isTitleEnabled = showToolbar
                    }
                }
            )

            toolbar.setNavigationOnClickListener { view ->
                view.findNavController().navigateUp()
            }

        }
        return binding.root
    }


    internal interface Callback {
        fun addToFavorite(movie: Movie)
    }
}